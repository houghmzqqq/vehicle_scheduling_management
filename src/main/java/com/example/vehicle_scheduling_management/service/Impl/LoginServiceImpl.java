package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.UserInfoMapper;
import com.example.vehicle_scheduling_management.pojo.UserInfo;
import com.example.vehicle_scheduling_management.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo login(String username, String password) {
        UserInfo user = userInfoMapper.validateUser(username,password);

        return user;
    }
}
