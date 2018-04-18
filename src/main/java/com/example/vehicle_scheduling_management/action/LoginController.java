package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.pojo.UserInfo;
import com.example.vehicle_scheduling_management.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletRequest request, Model model){
        UserInfo user = loginService.login(username,password);
        if (user==null){
            model.addAttribute("result","登录失败，请检查用户名和密码！");
            return "/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        System.out.println(user);
        return "index";
    }
}
