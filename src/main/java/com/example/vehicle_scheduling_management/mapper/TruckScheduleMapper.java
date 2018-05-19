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

    /**
     * @Author: yjf
     * @Description: 分页查询调度申请列表
     * @Param: firstData
     * @Param: rowOfEachPage
     * @Return:  List<TruckSchedulePO>
     * @Date: 10:17 2018/5/8
     */
    List<TruckSchedulePO> queryByDivide(@Param("firstData") int firstData,
                                        @Param("rowOfEachPage") int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 根据申请状态，分页查询调度申请
     * @Param: firstData
     * @Param: rowOfEachPage
     * @Param: appState
     * @Return: List<TruckSchedulePO>
     * @Date: 10:18 2018/5/8
     */
    List<TruckSchedulePO> queryByAppstate(@Param("firstData") int firstData,
                                          @Param("rowOfEachPage") int rowOfEachPage,
                                          @Param("appState") String appState);


    /**
     * @Author: yjf
     * @Description: 根据申请状态查找调度申请
     * @Param: status
     * @Return: List<TruckSchedulePO>
     * @Date: 16:31 2018/5/14
     */
    List<TruckSchedulePO> queryByStatus(String status);

//    List<TruckSchedulePO> sqjlQuery(@Param("firstData") int firstData,
//                                    @Param("rowOfEachPage") int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 查询所有调度申请的数量
     * @Param: null
     * @Return: int
     * @Date: 10:20 2018/5/8
     */
    int scheduleCount();

    /**
     * @Author: yjf
     * @Description: 根据申请状态查询调度申请的数量
     * @Param: appState
     * @Return: int
     * @Date: 10:05 2018/5/8
     */
    int shScheduleCount(@Param("appState") String appState);

    void add(TruckSchedulePO truckSchedulePO);

    void delete(int id);

    void update(TruckSchedulePO truckSchedulePO);
}
