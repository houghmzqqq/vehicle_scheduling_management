package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.OrderItemPO;
import com.example.vehicle_scheduling_management.pojo.PeccancyRecordPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Repository
public interface PeccancyRecordMapper {
    PeccancyRecordPO queryById(int id);

    /**
     * @Author: yjf
     * @Description: 分页查询
     * @Param: null
     * @Return: null
     * @Date: 13:39 2018/4/30
     */
    List<PeccancyRecordPO> queryByDivide(@Param("firstData") int firstData,
                                         @Param("rowOfEachPage") int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 查询总数
     * @Param: null
     * @Return: null
     * @Date: 13:40 2018/4/30
     */
    int peccancyCount();

    void add(PeccancyRecordPO peccancyRecordPO);

    void delete(int id);

    void update(PeccancyRecordPO peccancyRecordPO);
}
