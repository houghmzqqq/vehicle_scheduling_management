package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.example.vehicle_scheduling_management.vo.DriverVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Driver;
import java.util.Date;
import java.util.List;

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

    @Test
    @Transactional
    @Rollback(false)
    public void addTest(){
        DriverPO driverPO = new DriverPO("20181120141", "Jock", "0", 22,
        "C1","12345678941", "11152154@163.com", "ShangHai",
                "4415221995001", 2, "123456",
               new Date(), "0");
        driverService.add(driverPO);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateTest(){
        DriverPO driverPO = driverService.queryById(2);
        driverPO.setDriverName("吴贱");
        driverService.update(driverPO);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void deteleTest(){
        driverService.delete(1);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void queryAllTest(){
        List<DriverVO> driverPOS = driverService.queryAll();
        for(DriverVO driverPO : driverPOS){
            System.out.println(driverPO);
        }
    }
}