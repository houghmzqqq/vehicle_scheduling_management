package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.AccidenceRecodePO;
import com.example.vehicle_scheduling_management.vo.AccidenceRecodeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 17:50 2018/4/30
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
        "com.example.vehicle_scheduling_management.config",
        "com.example.vehicle_scheduling_management.action",
        "com.example.vehicle_scheduling_management.aspect"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class AccidenceTest {
    @Autowired
    private AccidenceService accidenceService;

    @Autowired
    private PeccancyService peccancyService;

    @Test
    public void addAccid(){
        AccidenceRecodeVO accidenceRecodePO =
                new AccidenceRecodeVO("粤A 56661", "JJ0001", "陈超",
        12.3f, 2.2f, 3.3f, 2,
        1, 109.3f, "史莱姆", "109876543526309865",
                "河北", "", "",
                "", "", "",
                "2018-4-1","", "",
                "", 1);
        accidenceService.add(accidenceRecodePO);
    }
}
