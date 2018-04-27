package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.service.OrdersService;
import com.example.vehicle_scheduling_management.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/getOrder")
    @ResponseBody
    public String getOrderById(@RequestParam(defaultValue = "1") int id, Model model){
        OrdersVO ordersVO = ordersService.queryById(id);
        model.addAttribute("order2",ordersVO);
        System.out.println(ordersVO);
        return "{'result':'success'}";
    }
}
