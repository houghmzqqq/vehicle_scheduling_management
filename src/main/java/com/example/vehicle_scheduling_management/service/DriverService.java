package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.DriverMapper;
import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.github.dozermapper.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<DriverPO> queryAll(){
        return driverMapper.queryAll();
    }

    public void add(DriverPO driverPO){
        driverMapper.add(driverPO);
    }

    public void update(DriverPO driverPO){
        driverMapper.update(driverPO);
    }

    public void delete(int id){
        driverMapper.delete(id);
    }
}
