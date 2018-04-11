package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.HistoryPathPO;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
public interface HistoryPathMapper {
    HistoryPathPO queryById(int id);

    void add(HistoryPathPO historyPathPO);

    void delete(int id);

    void update(HistoryPathPO historyPathPO);
}
