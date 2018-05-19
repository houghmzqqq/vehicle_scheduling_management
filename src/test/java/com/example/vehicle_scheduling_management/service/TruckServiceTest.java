package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.TruckMapper;
import com.example.vehicle_scheduling_management.pojo.TruckPO;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.TruckVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 21:13 2018/4/16
 * @modified by:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
        "com.example.vehicle_scheduling_management.config",
        "com.example.vehicle_scheduling_management.action",
        "com.example.vehicle_scheduling_management.aspect"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class TruckServiceTest {

    @Autowired
    private TruckService truckService;

    @Autowired
    private TruckMapper truckMapper;

    @Test
    @Transactional
    @Rollback(false)
    public void addTest(){
        TruckPO truckPO = new TruckPO("粤L 00001", "迅捷", "123","123", "123",
        10.5f, "红色", 1.6f, 4, new Date());
        for(int i=1;i<=20;i++){
            if(i<10){
                truckPO.setPlateNumber("粤A 0000"+i);
            }else{
                truckPO.setPlateNumber("粤A 000"+i);
            }

            truckMapper.add(truckPO);
        }

//        truckMapper.add(truckPO);
//        System.out.println(truckPO.getId());
    }

    @Test
    @Transactional
    @Rollback(false)
    public void divideTest(){
        DividePageVO<TruckVO> dividePage = truckService.divideQuery(1,3);
        System.out.println(dividePage);
    }

    @Test
    public void statusTest(){
        List<TruckVO> truckVOS = truckService.queryByStatus(0);
        System.out.println(truckVOS);
    }
}
