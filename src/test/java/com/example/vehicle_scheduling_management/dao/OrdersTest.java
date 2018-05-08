package com.example.vehicle_scheduling_management.dao;

import com.example.vehicle_scheduling_management.mapper.OrdersMapper;
import com.example.vehicle_scheduling_management.pojo.OrdersPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 18:03 2018/4/21
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
        "com.example.vehicle_scheduling_management.config",
        "com.example.vehicle_scheduling_management.action",
        "com.example.vehicle_scheduling_management.aspect",
        "com.example.vehicle_scheduling_management.filter"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class OrdersTest {

    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    @Transactional
    @Rollback(false)
    public void addTest(){
        OrdersPO ordersPO = new OrdersPO("天威网络", "陈文豪", "合同纸", 30.5f, 25.5f,
        "广东省", "惠州市", "惠城区江北东江二路富力国际中心", new Date(), 0,1,0);

        for(int i=1;i<=20;i++){
            ordersPO.setName("cc" + i);
            ordersPO.setGoodsName("杯子");
            ordersMapper.add(ordersPO);
        }
    }
}
