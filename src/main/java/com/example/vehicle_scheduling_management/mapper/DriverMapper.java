package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.DriverPO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
@Component
public interface DriverMapper {
    DriverPO queryById(int id);

    List<DriverPO> queryAll();

    List<DriverPO> queryByFilter(String filter);

    void add(DriverPO driver);

    void delete(int id);

    void update(DriverPO driver);
}
