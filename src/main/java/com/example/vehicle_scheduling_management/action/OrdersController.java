package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 23:09 2018/4/21
 * @modified by:
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/addTest")
    @ResponseBody
    public void addForTest(){
        ordersService.addForTest();
    }
}
