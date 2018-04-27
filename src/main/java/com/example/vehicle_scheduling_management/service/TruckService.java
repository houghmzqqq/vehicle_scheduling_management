package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.TruckVO;

import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 20:31 2018/4/16
 * @modified by:
 */
public interface TruckService {

    /**
     * @Author: yjf
     * @Description: 通过id查询车辆信息
     * @Param: id
     * @Return: TruckPO
     * @Date: 20:32 2018/4/16
     */
    TruckVO queryById(int id);

    /**
     * @Author: yjf
     * @Description: 通过状态查询车辆信息
     * @Param: status
     * @Return: List<TruckVO>
     * @Date: 17:19 2018/4/24
     */
    List<TruckVO> queryByStatus(int status);

    /**
     * @Author: yjf
     * @Description: 查询所有车辆信息
     * @Param: null
     * @Return: List<TruckPO>
     * @Date: 20:32 2018/4/16
     */
    List<TruckVO> queryAll();

    /**
     * @Author: yjf
     * @Description: 分页查询车辆信息
     * @Param: thisPage
     * @Param: rowOfEachPage
     * @Return: List<TruckVO>
     * @Date: 20:35 2018/4/16
     */
    DividePageVO<TruckVO> divideQuery(int thisPage, int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 新增车辆
     * @Param: truckPO
     * @Return: null
     * @Date: 20:33 2018/4/16
     */
    void add(TruckVO truckVO);

    /**
     * @Author: yjf
     * @Description: 删除车辆
     * @Param: id
     * @Return: null
     * @Date: 20:36 2018/4/16
     */
    void delete(int id);

    /**
     * @Author: yjf
     * @Description: 更新车辆信息
     * @Param: truckPO
     * @Return: null
     * @Date: 20:36 2018/4/16
     */
    void update(TruckVO truckVO);
}
