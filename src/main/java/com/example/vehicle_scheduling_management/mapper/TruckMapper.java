package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.OrderItemPO;
import com.example.vehicle_scheduling_management.pojo.TruckPO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Component
public interface TruckMapper {
    TruckPO queryById(int id);

    List<TruckPO> queryAll();

    void add(TruckPO truckPO);

    void delete(int id);

    void update(TruckPO truckPO);
}
