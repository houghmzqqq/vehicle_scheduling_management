package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.vo.OrdersVO;

import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 23:10 2018/4/21
 * @modified by:
 */
public interface OrdersService {

    /**
     * @Author: yjf
     * @Description: 通过一些条件如省份等查询订单信息
     * @Param: filter
     * @Return: List<OrdersVO>
     * @Date: 23:13 2018/4/21
     */
    List<OrdersVO> queryByFilter(String filter);

    void add(OrdersVO ordersVO);

    /**
     * @Author: yjf
     * @Description: 批量增加订单，测试用
     * @Param: null
     * @Return: null
     * @Date: 23:14 2018/4/21
     */
    void addForTest();


}
