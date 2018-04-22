package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.OrdersPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 17:30 2018/4/21
 * @modified by:
 */
@Component
public interface OrdersMapper {

    /**
     * @Author: yjf
     * @Description: 通过id查询订单
     * @Param: id
     * @Return: OrdersPO
     * @Date: 17:32 2018/4/21
     */
    OrdersPO queryById(int id);

    /**
     * @Author: yjf
     * @Description: 通过地区条件查询订单
     * @Param: filter
     * @Return: List<OrdersPO>
     * @Date: 17:33 2018/4/21
     */
    List<OrdersPO> queryByFilter(@Param("filter") String filter);

    void add(OrdersPO ordersPO);

    void delete(int id);

    void update(OrdersPO ordersPO);


}
