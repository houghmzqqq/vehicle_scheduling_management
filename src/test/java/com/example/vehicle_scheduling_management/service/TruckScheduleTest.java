package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.TruckScheduleMapper;
import com.example.vehicle_scheduling_management.pojo.OrdersPO;
import com.example.vehicle_scheduling_management.pojo.TruckSchedulePO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class

TruckScheduleTest {

    @Autowired
    private ScheduleService service;
    @Autowired
    private TruckScheduleMapper scheduleMapper;

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

    @Test
    public void test04() throws Exception {
        System.out.println(service.getOrdersEndPoi());
    }

    @Test
    public void test05() throws Exception {
        System.out.println(service.getOrdersPath());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void test06(){
        service.createSchedule();
    }

    /**
     * @Author: yjf
     * @Description: 将测试数据写到文件中
     * @Param: null
     * @Return: null
     * @Date: 20:35 2018/5/22
     */
    @Test
    public void test07(){
        List<TruckSchedulePO> ordersPOS = scheduleMapper.queryByDivide(1,50);

    }
}
