package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.pojo.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(UserInfo userInfo){

        return "index";
    }
}
