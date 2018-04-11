package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.OrderItemPO;
import com.example.vehicle_scheduling_management.pojo.PeccancyRecordPO;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
public interface PeccancyRecordMapper {
    PeccancyRecordPO queryById(int id);

    void add(PeccancyRecordPO peccancyRecordPO);

    void delete(int id);

    void update(PeccancyRecordPO peccancyRecordPO);
}
