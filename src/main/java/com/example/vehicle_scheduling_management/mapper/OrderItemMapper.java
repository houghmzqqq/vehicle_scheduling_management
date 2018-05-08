package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.HistoryPathPO;
import com.example.vehicle_scheduling_management.pojo.OrderItemPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Repository
public interface OrderItemMapper {
    /**
     * @Author: yjf
     * @Description: 通过订单id查询订单项
     * @Param: orderId
     * @Return: OrderItemPO
     * @Date: 10:27 2018/5/8
     */
    OrderItemPO queryById(@Param("orderId") int orderId);

    /**
     * @Author: yjf
     * @Description: 根据调度申请的id查找订单项
     * @Param: scheId
     * @Return: List<OrderItemPO>
     * @Date: 10:26 2018/5/8
     */
    List<OrderItemPO> queryBySchId(@Param("scheId") int scheId);

    void add(OrderItemPO orderItemPO);

    void delete(int id);

    /**
     * @Author: yjf
     * @Description: 删除与该调度申请相关的订单项
     * @Param: scheId
     * @Return: null
     * @Date: 10:31 2018/5/8
     */
    void deleteByScheId(@Param("scheId") int scheId);

    void update(OrderItemPO orderItemPO);

}
