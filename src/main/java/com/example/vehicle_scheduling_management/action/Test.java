package com.example.vehicle_scheduling_management.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

    @RequestMapping("/users")
    public String myTest(Model model){
        model.addAttribute("username","叶俊锋");
        return "index";
    }

    @RequestMapping("/header")
    public String myTest02(){
        return "header";
    }

    @RequestMapping("/sidebar")
    public String myTest03(){
        return "sidebar";
    }

    @RequestMapping("/index")
    public String myTest04(){
        return "index";
    }
}
