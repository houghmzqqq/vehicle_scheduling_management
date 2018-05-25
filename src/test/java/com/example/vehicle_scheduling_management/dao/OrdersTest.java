package com.example.vehicle_scheduling_management.dao;

import com.example.vehicle_scheduling_management.mapper.*;
import com.example.vehicle_scheduling_management.pojo.OrdersPO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private TruckMapper truckMapper;
    @Autowired
    private DriverMapper driverMapper;
    @Autowired
    private HistoryPathMapper pathMapper;
    @Autowired
    private PeccancyRecordMapper peccancyMapper;

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

    @Test
    public void test03() throws IOException {
        List ordersPOS = ordersMapper.queryByFilter("");

        JSONArray jsonArray = JSONArray.fromObject(ordersPOS);
        writeObj(jsonArray.toString().getBytes(),"D://orderPOS.txt");

        ordersPOS = truckMapper.queryAll();
        jsonArray = JSONArray.fromObject(ordersPOS);
        writeObj(jsonArray.toString().getBytes(),"D://truckPOS.txt");
        ordersPOS = driverMapper.queryAll();
        jsonArray = JSONArray.fromObject(ordersPOS);
        writeObj(jsonArray.toString().getBytes(),"D://driverPOS.txt");
        ordersPOS = pathMapper.queryAll();
        jsonArray = JSONArray.fromObject(ordersPOS);
        writeObj(jsonArray.toString().getBytes(),"D://HistoryPOS.txt");
//        ordersPOS = peccancyMapper..queryAll();

    }

    @Test
    public void test04(){

    }

    public void writeObj(byte[] bytes,String fileName) throws IOException {
        FileOutputStream out = new FileOutputStream(new File(fileName));

        out.write(bytes);
    }
}
