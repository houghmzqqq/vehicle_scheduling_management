package com.example.vehicle_scheduling_management.service;

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
 * @Date: create in 20:00 2018/4/26
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
        "com.example.vehicle_scheduling_management.config",
        "com.example.vehicle_scheduling_management.action",
        "com.example.vehicle_scheduling_management.aspect"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class TruckScheduleTest {

    @Autowired
    private ScheduleService service;

    @Test
    public void createTest(){
        service.createSchedule(5,2,1);
    }

    @Test
    public void queryByDivide(){
        System.out.println(service.divideQuery(1,3));
    }

    @Test
    public void shTest(){
        System.out.println(service.getShList(1,2));
    }
}
