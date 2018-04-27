package com.example.vehicle_scheduling_management.service.Impl;


import com.example.vehicle_scheduling_management.mapper.*;
import com.example.vehicle_scheduling_management.pojo.*;
import com.example.vehicle_scheduling_management.service.ScheduleService;
import com.example.vehicle_scheduling_management.util.MapUtil;
import com.example.vehicle_scheduling_management.util.UrlTool;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 19:50 2018/4/23
 * @modified by:
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private TruckMapper truckMapper;
    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private TruckScheduleMapper scheduleMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private TruckItemMapper truckItemMapper;

    private JSONObject jsonObject;

    @Override
    @Transactional
    public void createSchedule(int driverId, int truckId, int orderId) {
        OrdersPO ordersPO = ordersMapper.queryById(orderId);
        TruckPO truckPO = truckMapper.queryById(truckId);
        DriverPO driverPO = driverMapper.queryById(driverId);

        //1.生成一条车辆调度申请记录
        TruckSchedulePO truckSchedulePO = new TruckSchedulePO();
        truckSchedulePO.setStartPlace(MapUtil.COMPANY_LOCATION);
        String totalAddress = ordersPO.getProvince()+ordersPO.getCity()+ordersPO.getDetailedAddress();
        truckSchedulePO.setEndPlace(totalAddress);
        //设置运输跨度
        if(!ordersPO.getProvince().equals("广东省")){
            truckSchedulePO.setSpan("0");
        }else if(!ordersPO.getCity().equals("惠州市")){
            truckSchedulePO.setSpan("1");
        }else{
            truckSchedulePO.setSpan("2");
        }
        //设置为送货
        truckSchedulePO.setAim("1");
        //申请状态设为为提交
        truckSchedulePO.setApplicationState("0");
//        truckSchedulePO.setApplicationDate(new Date());

        //备注
        truckSchedulePO.setRemark("");
        scheduleMapper.add(truckSchedulePO);

        //2.生成调度订单项
        OrderItemPO orderItemPO = new OrderItemPO();
        orderItemPO.setOrderId(orderId);
        orderItemPO.setScheduleId(truckSchedulePO.getId());
        orderItemMapper.add(orderItemPO);

        //3.生成调度车辆项
        TruckItemPO truckItemPO = new TruckItemPO();
        truckItemPO.setScheduleId(truckSchedulePO.getId());
        truckItemPO.setPlateNumber(truckPO.getPlateNumber());
        truckItemPO.setDriverCode(driverPO.getDriverCode());
        truckItemPO.setDriverName(driverPO.getDriverName());
        truckItemMapper.add(truckItemPO);

        //4.修改货车状态，修改司机状态，修改订单状态
        truckPO.setStatus(1); //改为出车中
        driverPO.setState("0"); //改为出车中
        ordersPO.setStatus(2); //改为送货中
        truckMapper.update(truckPO);
        driverMapper.update(driverPO);
        ordersMapper.update(ordersPO);

    }

    @Override
    @Transactional
    public String getLocalPosition() {
        String position = "";
        try {
            UrlTool urlTool = new UrlTool("http://restapi.amap.com/v3/geocode/geo?" +
                    "key=a5adf042b0fb331d06dacd542469c1c8&address=惠州市惠城区河南岸公园小区");
            StringBuilder sb = new StringBuilder(urlTool.getResponseMsg());
            sb.insert(0,'{');

            jsonObject = JSONObject.fromObject(sb.toString());

            JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
            jsonObject = jsonArray.getJSONObject(0);
            position = jsonObject.getString("location");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }
}
