package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.AccidenceRecodePO;
import com.example.vehicle_scheduling_management.pojo.TruckSchedulePO;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
public interface AccidenceRecodeMapper {
    AccidenceRecodePO queryById(int id);

    void add(AccidenceRecodePO accidenceRecodePO);

    void delete(int id);

    void update(AccidenceRecodePO accidenceRecodePO);
}
