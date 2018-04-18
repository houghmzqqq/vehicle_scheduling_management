package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.UserInfo;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
public interface LoginService {

    /**
     * @Author: yjf
     * @Description: 登录
     * @Param: username
     * @Param: password
     * @Return: UserInfo
     * @Date: 16:54 2018/4/18
     */
    UserInfo login(String username,String password);


}
