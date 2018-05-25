package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.exception.NoTruckItemFindException;
import com.example.vehicle_scheduling_management.vo.*;

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

    /**
     * @Author: yjf
     * @Description: 批量生成调度申请
     * @Param: null
     * @Return: String
     * @Date: 16:06 2018/5/22
     */
    String createSchedule();

    String getLocalPosition();

    /**
     * @Author: yjf
     * @Description: 分页查询调度单
     * @Param: thisPage
     * @Param: rowOfEachPage
     * @Return: DividePageVO<TruckScheduleVO>
     * @Date: 12:08 2018/4/30
     */
    DividePageVO<TruckScheduleVO> divideQuery(int thisPage,int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 提交调度申请
     * @Param: id
     * @Return: null
     * @Date: 14:01 2018/5/7
     */
    void submit(int id);

    /**
     * @Author: yjf
     * @Description: 获取调度申请的审核列表
     * @Param: thisPage
     * @Param: rowOfEachPage
     * @Return: DividePageVO<TruckScheduleShVO>
     * @Date: 10:00 2018/5/8
     */
    DividePageVO<TruckScheduleShVO> getShList(int thisPage, int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 审核调度申请
     * @Param: scheId
     * @Param: state
     * @Return: int
     * @Date: 20:33 2018/5/9
     */
    int shSche(int scheId,String state);

    /**
     * @Author: yjf
     * @Description: 获取已完成的调度申请的车辆项
     * @Param: null
     * @Return: null
     * @Date: 16:47 2018/5/14
     */
    List<LsgjVO> getLsgjList() throws NoTruckItemFindException;

    /**
     * @Author: yjf
     * @Description: 获取某个车辆项的历史轨迹
     * @Param: truckItemId
     * @Return: String
     * @Date: 12:07 2018/5/16
     */
    String getLisgStep(int truckItemId);

    /**
     * @Author: yjf
     * @Description: 根据调度单的状态查找调度申请
     * @Param: status
     * @Return: List<TruckScheduleVO>
     * @Date: 9:43 2018/5/19
     */
    List<TruckScheduleVO> getSchesByStatus(String status);

    /**
     * @Author: yjf
     * @Description: 根据Id查找调度记录
     * @Param: id
     * @Return: TruckScheduleVO
     * @Date: 10:00 2018/5/19
     */
    TruckScheduleShVO getScheById(int id);

    /**
     * @Author: yjf
     * @Description: 获取所有待发货（1）状态的订单的目的地poi信息
     * @Param: null
     * @Return: String
     * @Date: 21:04 2018/5/19
     */
    String getOrdersEndPoi() throws Exception;

    /**
     * @Author: yjf
     * @Description: 获取所有带发货订单的路径规划
     * @Param: null
     * @Return: String
     * @Date: 10:46 2018/5/20
     */
    String getOrdersPath() throws Exception;
}
