package com.example.vehicle_scheduling_management.filter;

import com.example.vehicle_scheduling_management.config.RoleConfig;
import com.example.vehicle_scheduling_management.pojo.UserInfo;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by 叶俊锋 on 2018/4/19.
 */
public class RoleInterceptor implements HandlerInterceptor{

    /**
     * @Author: yjf
     * @Description: 对访问各个模块的请求进行拦截，判断该用户是否具有权限
     * @Date: 15:00 2018/4/19
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求的uri
        String uri = request.getRequestURI();
        //获取用户信息
        HttpSession session = request.getSession();
        UserInfo user = (UserInfo) session.getAttribute("user");

        //获取角色权限配置
        RoleConfig roleConfig = new RoleConfig();
        Map permiss = roleConfig.getPermiss();
        List<RoleConfig.RoleModel> models = (List) permiss.get(user.getRole());

        for(RoleConfig.RoleModel model : models){
            for(String reqUri : model.getUrls()){
                if(reqUri.equals(uri))
                    return true;
            }
        }

//        System.out.println("用户：" + user.);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

    }
}
