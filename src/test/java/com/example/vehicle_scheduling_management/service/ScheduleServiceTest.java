package com.example.vehicle_scheduling_management.service;

import javafx.concurrent.ScheduledService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 11:23 2018/4/23
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleServiceTest {

    @Autowired
    private OrdersService service;

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void queryTypes(){
        System.out.println(service.queryByTypes(0));
    }

    @Test
    public void getTest(){
        String position = scheduleService.getLocalPosition();
        System.out.println(position);
    }

}
