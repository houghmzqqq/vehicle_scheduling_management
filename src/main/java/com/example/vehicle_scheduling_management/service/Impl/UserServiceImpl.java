package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.UserInfoMapper;
import com.example.vehicle_scheduling_management.pojo.UserInfo;
import com.example.vehicle_scheduling_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
public class UserServiceImpl implements UserService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo queryById(Integer id) {

        return userInfoMapper.queryById(id);
    }

    @Override
    public List<UserInfo> queryAll() {
        return userInfoMapper.queryAll();
    }

    @Override
    public void add(UserInfo userInfo) {
        userInfoMapper.add(userInfo);
    }

    @Override
    public void delete(int id) {
        userInfoMapper.delete(id);
    }

    @Override
    public void update(UserInfo userInfo) {
        userInfoMapper.update(userInfo);
    }
}
