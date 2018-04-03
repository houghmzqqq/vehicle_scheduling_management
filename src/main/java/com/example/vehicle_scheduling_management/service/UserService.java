package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.UserInfoMapper;
import com.example.vehicle_scheduling_management.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo queryById(Integer id){
        return userInfoMapper.queryById(id);
    }
}
