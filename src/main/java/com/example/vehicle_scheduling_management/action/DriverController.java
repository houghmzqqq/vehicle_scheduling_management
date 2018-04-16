package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.example.vehicle_scheduling_management.service.DriverService;
import com.example.vehicle_scheduling_management.vo.DriverVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/12.
 */
@Controller
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @RequestMapping("/toList")
    public String toDriverList(Model model){
        List<DriverVO> driverVOS = driverService.queryAll();
        model.addAttribute("drivers",driverVOS);
        return "/driver/driver-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/driver/driver-add";
    }

    @RequestMapping("/test")
    public String test02(){
        return "/driver/driver-add";
    }
}
