package com.example.vehicle_scheduling_management.service.Impl;


import com.example.vehicle_scheduling_management.mapper.*;
import com.example.vehicle_scheduling_management.pojo.*;
import com.example.vehicle_scheduling_management.service.ScheduleService;
import com.example.vehicle_scheduling_management.util.DivideUtil;
import com.example.vehicle_scheduling_management.util.MapUtil;
import com.example.vehicle_scheduling_management.util.UrlTool;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.TruckScheduleShVO;
import com.example.vehicle_scheduling_management.vo.TruckScheduleVO;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private DivideUtil divideUtil;
    @Autowired
    private DozerBeanMapper beanMapper;

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
        //设置为'送货'
        truckSchedulePO.setAim("1");
        //申请状态设为'未提交'
        truckSchedulePO.setApplicationState("0");
//        truckSchedulePO.setApplicationDate(new Date());
        //设置为'待执行'
        truckSchedulePO.setStatus("0");

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
            //获取返回的结果
            String msg = urlTool.getResponseMsg();

            jsonObject = JSONObject.fromObject(msg);
            JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
            jsonObject = jsonArray.getJSONObject(0);
            position = jsonObject.getString("location");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }

    @Override
    @Transactional
    public void submit(int id) {
        TruckSchedulePO truckSchedulePO = scheduleMapper.queryById(id);
        truckSchedulePO.setApplicationDate(new Date());
        truckSchedulePO.setApplicationState("1");

        scheduleMapper.update(truckSchedulePO);
    }

    @Override
    @Transactional
    public DividePageVO<TruckScheduleVO> divideQuery(int thisPage, int rowOfEachPage) {
        List<TruckSchedulePO> schedulePOS =
                scheduleMapper.queryByDivide((thisPage-1)*rowOfEachPage,rowOfEachPage);
        List<TruckScheduleVO> scheduleVOS = new ArrayList<>();
        int count = scheduleMapper.scheduleCount();
        DividePageVO<TruckScheduleVO> dividePage =
                divideUtil.getDividePageVO(thisPage,rowOfEachPage,count);

        for(TruckSchedulePO schedulePO : schedulePOS){
            scheduleVOS.add(this.turnPoToVo(schedulePO));
        }

        dividePage.setObjList(scheduleVOS);

        return dividePage;
    }

    @Override
    public DividePageVO<TruckScheduleShVO> getShList(int thisPage, int rowOfEachPage) {
        List<TruckSchedulePO> schedulePOS = scheduleMapper.queryByAppstate((thisPage-1)*rowOfEachPage,rowOfEachPage,"1");
        List<TruckScheduleShVO> scheduleShVOS = new ArrayList<>();
        int count = scheduleMapper.shScheduleCount("1");

        DividePageVO<TruckScheduleShVO> dividePageVO = divideUtil.getDividePageVO(thisPage,rowOfEachPage,count);

        List<TruckItemPO> truckItemPOS = new ArrayList<>();
        List<OrderItemPO> orderItemPOS = new ArrayList<>();
        //生成scheduleShVOS
        for(TruckSchedulePO schedulePO : schedulePOS){
            TruckScheduleShVO scheduleShVO = new TruckScheduleShVO();

            int scheId = schedulePO.getId();
            truckItemPOS = truckItemMapper.queryByScheId(scheId);
            orderItemPOS = orderItemMapper.queryBySchId(scheId);
            TruckItemPO truckItemPO = new TruckItemPO();
            OrderItemPO orderItemPO = new OrderItemPO();
            if(truckItemPOS != null  &&  truckItemPOS.size() != 0)
                truckItemPO = truckItemPOS.get(0);
            if(orderItemPOS != null  &&  orderItemPOS.size() != 0)
                orderItemPO = orderItemPOS.get(0);

            OrdersPO ordersPO = ordersMapper.queryById(orderItemPO.getOrderId());

            beanMapper.map(turnPoToVo(schedulePO),scheduleShVO);
            //设置货车信息
            scheduleShVO.setTruckId(truckItemPO.getTruckId());
            scheduleShVO.setPlateNumber(truckItemPO.getPlateNumber());
            //设置司机信息
            scheduleShVO.setDriverId(truckItemPO.getDriverId());
            scheduleShVO.setDriverName(truckItemPO.getDriverName());
            //设置订单信心
            scheduleShVO.setOrderId(orderItemPO.getOrderId());
            scheduleShVO.setCompany(ordersPO.getCompany());

            scheduleShVOS.add(scheduleShVO);
        }

        dividePageVO.setObjList(scheduleShVOS);

        return dividePageVO;
    }

    /**
     * @Author: yjf
     * @Description: PO转换为VO
     * @Param: schedulePO
     * @Return: TruckScheduleVO
     * @Date: 12:50 2018/4/30
     */
    public TruckScheduleVO turnPoToVo(TruckSchedulePO schedulePO){
        String applivationState = schedulePO.getApplicationState();
        String status = schedulePO.getStatus();
        String aim = schedulePO.getAim();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        TruckScheduleVO scheduleVO = new TruckScheduleVO();
        beanMapper.map(schedulePO,scheduleVO);

        if(schedulePO != null){
            //转换日期格式
            if(schedulePO.getApplicationDate() != null){
                String applicationDate = sdf.format(schedulePO.getApplicationDate());
                scheduleVO.setApplicationDate(applicationDate);
            }
            if(schedulePO.getAccessDate() != null){
                String accessDate = sdf.format(schedulePO.getAccessDate());
                scheduleVO.setAccessDate(accessDate);
            }

            //转换申请状态
            if(applivationState != null  &&  !applivationState.equals("")){
                if("0".equals(applivationState)){
                    scheduleVO.setApplicationState("未提交");
                }else if("1".equals(applivationState)){
                    scheduleVO.setApplicationState("申请中");
                }else if("2".equals(applivationState)){
                    scheduleVO.setApplicationState("审批通过");
                }else if("3".equals(applivationState)){
                    scheduleVO.setApplicationState("审批未通过");
                }
            }

            //转换调度状态
            if(status != null  &&  !status.equals("")){
                if("0".equals(status)){
                    scheduleVO.setStatus("待执行");
                }else if("1".equals(status)){
                    scheduleVO.setStatus("执行中");
                }else if("2".equals(status)){
                    scheduleVO.setStatus("已完成");
                }
            }

            //转换用车类型
            if(aim != null  &  !aim.equals("")){
                if("0".equals(aim)){
                    scheduleVO.setAim("上门提货");
                }else if("1".equals(aim)){
                    scheduleVO.setAim("送货");
                }
            }

        }

        return scheduleVO;
    }
}
