package com.example.vehicle_scheduling_management.action;

import com.example.vehicle_scheduling_management.pojo.UserInfo;
import com.example.vehicle_scheduling_management.service.LoginService;
import com.sun.net.httpserver.HttpsConfigurator;
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
        return "/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, Model model){
        UserInfo user = loginService.login(username,password);
        if (user==null){
            model.addAttribute("result","登录失败，请检查用户名和密码！");
            return "/login";
        }

        session.setAttribute("user",user);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        //不产生新的session，request.getSession()如果不存在session，它会创建一个新的
        HttpSession session = request.getSession(false);
        if(session != null){
            session.removeAttribute("user");
        }
        return "/login";
    }
}
