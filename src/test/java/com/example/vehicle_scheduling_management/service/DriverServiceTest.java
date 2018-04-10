package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.DriverPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DriverServiceTest {

    @Autowired
    private DriverService driverService;

    @Test
    public void queryById() throws Exception {
        DriverPO driverPO = driverService.queryById(1);
        System.out.println(driverPO);
    }

}