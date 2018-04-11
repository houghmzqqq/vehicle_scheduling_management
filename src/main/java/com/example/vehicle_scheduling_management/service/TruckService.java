package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.TruckMapper;
import com.example.vehicle_scheduling_management.pojo.TruckPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Service
public class TruckService {
    @Autowired
    private TruckMapper truckMapper;

    public TruckPO queryById(int id){
        return truckMapper.queryById(id);
    }

    public List<TruckPO> queryAll(){
        return truckMapper.queryAll();
    }

    public void add(TruckPO truckPO){
        truckMapper.add(truckPO);
    }

    public void delete(int id){
        truckMapper.delete(id);
    }

    public void update(TruckPO truckPO){
        truckMapper.update(truckPO);
    }
}
