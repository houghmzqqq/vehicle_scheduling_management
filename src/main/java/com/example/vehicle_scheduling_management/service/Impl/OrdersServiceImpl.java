package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.OrdersMapper;
import com.example.vehicle_scheduling_management.pojo.OrdersPO;
import com.example.vehicle_scheduling_management.service.OrdersService;
import com.example.vehicle_scheduling_management.vo.OrdersVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 23:15 2018/4/21
 * @modified by:
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private DozerBeanMapper beanMapper;

    @Override
    public List<OrdersVO> queryByFilter(String filter) {

        return null;
    }

    @Override
    public OrdersVO queryById(int id) {
        OrdersPO ordersPO = ordersMapper.queryById(id);
        return turnPoToVo(ordersPO);
    }

    @Override
    public List<OrdersVO> queryByTypes(int types) {

        List<OrdersPO> ordersPOS = ordersMapper.queryByTypes(types);
        List<OrdersVO> ordersVOS = new ArrayList<>();

        for(OrdersPO ordersPO : ordersPOS){
            ordersVOS.add(turnPoToVo(ordersPO));
        }

        return ordersVOS;
    }

    @Override
    public void add(OrdersVO ordersVO) {

    }

    @Override
    public void addForTest() {
        OrdersPO ordersPO = new OrdersPO("天威网络", "陈文豪", "合同纸", 30.5f, 25.5f,
                "广东省", "惠州市", "惠城区江北东江二路富力国际中心", new Date(), 0,1,0);
        for(int i=1;i<=10;i++){
            ordersPO.setName("经办人" + i);
            ordersMapper.add(ordersPO);
        }
    }

    public OrdersVO turnPoToVo(OrdersPO ordersPO){
        OrdersVO ordersVO = new OrdersVO();

        beanMapper.map(ordersPO,ordersVO);

        String address = ordersPO.getProvince()+ordersPO.getCity()+ordersPO.getDetailedAddress();
        ordersVO.setTotalAddress(address);

        if(ordersPO.getTypes() == 0){
            ordersVO.setTypes("整车");
        }else if (ordersPO.getTypes() == 1){
            ordersVO.setTypes("零担");
        }

        if(ordersPO.getStatus() == 0){
            ordersVO.setStatus("待提货");
        }else if(ordersPO.getStatus() == 1){
            ordersVO.setStatus("待发货");
        }else if(ordersPO.getStatus() == 2){
            ordersVO.setStatus("送货中");
        }else if(ordersPO.getStatus() == 3){
            ordersVO.setStatus("已签收");
        }

        if(ordersPO.getIsToBring() == 0){
            ordersVO.setIsToBring("否");
        }else if(ordersPO.getIsToBring() == 1){
            ordersVO.setIsToBring("是");
        }

        return ordersVO;
    }
}
