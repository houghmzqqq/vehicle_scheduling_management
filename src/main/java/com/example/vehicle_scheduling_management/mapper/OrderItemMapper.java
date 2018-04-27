package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.HistoryPathPO;
import com.example.vehicle_scheduling_management.pojo.OrderItemPO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Repository
public interface OrderItemMapper {
    OrderItemPO queryById(int id);

    void add(OrderItemPO orderItemPO);

    void delete(int id);

    void update(OrderItemPO orderItemPO);
}
