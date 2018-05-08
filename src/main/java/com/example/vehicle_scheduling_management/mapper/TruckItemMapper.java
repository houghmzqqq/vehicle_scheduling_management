package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.OrderItemPO;
import com.example.vehicle_scheduling_management.pojo.TruckItemPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Repository
public interface TruckItemMapper {
    /**
     * @Author: yjf
     * @Description: 通过货车id查询车辆项
     * @Param: truckId
     * @Return: TruckItemPO
     * @Date: 10:35 2018/5/8
     */
    TruckItemPO queryByTruckId(@Param("truckId") int truckId);

    /**
     * @Author: yjf
     * @Description: 通过调度申请id查询车辆项
     * @Param: scheId
     * @Return: List<TruckItemPO>
     * @Date: 10:45 2018/5/8
     */
    List<TruckItemPO> queryByScheId(@Param("scheId") int scheId);

    void add(TruckItemPO truckItemPO);

    void delete(int id);

    /**
     * @Author: yjf
     * @Description: 删除与该调度申请有关的车辆项
     * @Param: scheId
     * @Return: null
     * @Date: 10:51 2018/5/8
     */
    void deleteByScheId(@Param("scheId") int scheId);

    void update(TruckItemPO truckItemPO);
}
