package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.TruckPO;
import com.example.vehicle_scheduling_management.pojo.TruckSchedulePO;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
public interface TruckScheduleMapper {
    TruckSchedulePO queryById(int id);

    void add(TruckSchedulePO truckSchedulePO);

    void delete(int id);

    void update(TruckSchedulePO truckSchedulePO);
}
