package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.TruckSchedulePO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Repository
public interface TruckScheduleMapper {
    TruckSchedulePO queryById(int id);

    List<TruckSchedulePO> queryByDivide(@Param("fristData") int fristData,
                                        @Param("rowOfEachPage") int rowOfEachPage);

    void add(TruckSchedulePO truckSchedulePO);

    void delete(int id);

    void update(TruckSchedulePO truckSchedulePO);
}
