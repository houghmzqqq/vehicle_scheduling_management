package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.DriverVO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface DriverService {

    /**
     * @Author: yjf
     * @Description: 通过id查找司机信息
     * @Param: int
     * @Return: DriverVO
     * @Date: 20:47 2018/4/14
     */
    DriverVO queryById(int id);

    /**
     * @Author: yjf
     * @Description: 查找所有司机
     * @Param: null
     * @Return: List<DriverVO>
     * @Date: 20:49 2018/4/14
     */
    List<DriverVO> queryAll();

    /**
     * @Author: yjf
     * @Description: 根据状态查询司机
     * @Param: status
     * @Return: List<DriverVO>
     * @Date: 17:32 2018/4/24
     */
    List<DriverVO> queryByStatus(String status);

    /**
     * @Author: yjf
     * @Description: 分页查询司机信息
     * @Param: thisPage
     * @Param: rowOfEachPage
     * @Return: DividePageVO<DriverVO>
     * @Date: 11:37 2018/4/15
     */
    DividePageVO<DriverVO> divideQuery(Integer thisPage, Integer rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 向数据库新增司机
     * @Param: DriverVO
     * @Return: null
     * @Date: 20:50 2018/4/14
     */
    void add(DriverVO driverVO) throws ParseException;

    /**
     * @Author: yjf
     * @Description: 跟新司机信息
     * @Param: DriverVO
     * @Return: null
     * @Date: 20:50 2018/4/14
     */
    void update(DriverVO driverVO);

    /**
     * @Author: yjf
     * @Description: 删除司机信息
     * @Param: int
     * @Return: null
     * @Date: 20:51 2018/4/14
     */
    void delete(int id);
}
