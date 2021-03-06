package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.OrderItemPO;
import com.example.vehicle_scheduling_management.pojo.TruckItemPO;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
public interface TruckItemMapper {
    TruckItemPO queryById(int id);

    void add(TruckItemPO truckItemPO);

    void delete(int id);

    void update(TruckItemPO truckItemPO);
}
