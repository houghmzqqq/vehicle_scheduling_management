package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserInfoMapper {

    UserInfo queryById(Integer id);

}
