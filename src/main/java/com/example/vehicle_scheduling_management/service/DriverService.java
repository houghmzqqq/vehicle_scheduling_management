package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.DriverMapper;
import com.example.vehicle_scheduling_management.pojo.DriverPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;

    public DriverPO queryById(int id){
        return driverMapper.queryById(id);
    }
}
