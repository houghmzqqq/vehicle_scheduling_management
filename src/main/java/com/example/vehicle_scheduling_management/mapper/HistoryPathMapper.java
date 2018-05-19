package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.HistoryPathPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
public interface HistoryPathMapper {
    HistoryPathPO queryById(int id);

    List<HistoryPathPO> queryAll();

    List<HistoryPathPO> queryByDivide(@Param("firstData") int firstData,
                                      @Param("rowOfEachPage") int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 通过truckItemId查找历史轨迹
     * @Param: truckItemId
     * @Return: List<HistoryPathPO>
     * @Date: 16:33 2018/5/14
     */
    List<HistoryPathPO> queryByItemId(int truckItemId);

    void add(HistoryPathPO historyPathPO);

    void delete(int id);

    void update(HistoryPathPO historyPathPO);
}
