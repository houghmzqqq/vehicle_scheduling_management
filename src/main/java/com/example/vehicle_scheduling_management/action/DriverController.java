package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.service.DriverService;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.DriverVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
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
    public String toDriverList(Model model, @RequestParam(defaultValue = "1") Integer thisPage){
//        List<DriverVO> driverVOS = driverService.queryAll();
        DividePageVO dividePage = driverService.divideQuery(thisPage,3);
        model.addAttribute("dividePage",dividePage);
        System.out.println(dividePage);
        return "/driver/driver-list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "/driver/driver-add";
    }

    @RequestMapping("/addDriver")
    public String addDriver(DriverVO driverVO){
        try {
            driverService.add(driverVO);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "redirect:/driver/toList";
    }


}
