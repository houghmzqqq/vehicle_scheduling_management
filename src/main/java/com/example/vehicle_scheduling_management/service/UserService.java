package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.UserInfoMapper;
import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.example.vehicle_scheduling_management.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface UserService {

    UserInfo queryById(Integer id);

    List<UserInfo> queryAll();

    void add(UserInfo userInfo);

    void delete(int id);

    void update(UserInfo userInfo);
}
