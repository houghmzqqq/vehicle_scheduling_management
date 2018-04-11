package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.TruckPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TruckTest {
    @Autowired
    public TruckService truckService;

    @Test
    @Transactional
    @Rollback(false)
    public void addTest(){
        TruckPO truckPO = new TruckPO("粤A B6521", "夕阳红车队", "大运轻卡", "祺运",
                "90马力 3.9米半排半栏板轻卡", 1.75f, "红色", 2.672f, 3, new Date());
        truckService.add(truckPO);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void queryTest1(){
        TruckPO truckPO = truckService.queryById(1);
        System.out.println(truckPO);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void queryTest2(){
        List<TruckPO> truckPOS = truckService.queryAll();
        for(TruckPO truckPO : truckPOS){
            System.out.println(truckPO);
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    public void updateTest(){
        TruckPO truckPO = truckService.queryById(2);
        truckPO.setFleetName("速度与激情车队");
        truckService.update(truckPO);
    }
}
