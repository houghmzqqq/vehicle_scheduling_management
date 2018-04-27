package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.vo.OrdersVO;

import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 11:25 2018/4/23
 * @modified by:
 */
public interface ScheduleService {

    /**
     * @Author: yjf
     * @Description: 生成车辆调度申请
     * @Param: driverId
     * @Param: truckId
     * @Param: orderId
     * @Date: 21:11 2018/4/25
     */
    void createSchedule(int driverId,int truckId,int orderId);

    String getLocalPosition();

}
