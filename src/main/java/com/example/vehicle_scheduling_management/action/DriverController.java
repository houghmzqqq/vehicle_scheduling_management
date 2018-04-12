package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.example.vehicle_scheduling_management.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/12.
 */
@Controller
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("toList")
    public String toDriverList(Model model){
        List<DriverPO> driverPOS = driverService.queryAll();
        model.addAttribute("drivers",driverPOS);
        return "driver-list";
    }
}