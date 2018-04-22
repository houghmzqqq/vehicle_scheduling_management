package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.OrdersMapper;
import com.example.vehicle_scheduling_management.pojo.OrdersPO;
import com.example.vehicle_scheduling_management.service.OrdersService;
import com.example.vehicle_scheduling_management.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<OrdersVO> queryByFilter(String filter) {
        return null;
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
}
