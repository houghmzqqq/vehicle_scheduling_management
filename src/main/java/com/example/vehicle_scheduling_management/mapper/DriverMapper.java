package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.DriverPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
@Component
public interface DriverMapper {
    /**
     * @Author: yjf
     * @Description: 通过id查找司机信息
     * @Param: int
     * @Return: DriverPO
     * @Date: 11:55 2018/4/15
     */
    DriverPO queryById(int id);

    /**
     * @Author: yjf
     * @Description: 查找所有司机信息
     * @Param: null
     * @Return: List<DriverPO>
     * @Date: 11:55 2018/4/15
     */
    List<DriverPO> queryAll();

    /**
     * @Author: yjf
     * @Description: 分页查找司机信息
     * @Param: first
     * @Param: rowOfEachPage
     * @Param: filter
     * @Return: List<DriverPO>
     * @Date: 11:55 2018/4/15
     */
    List<DriverPO> queryByDivide(@Param("firstData") int firstData,
                                 @Param("rowOfEachPage") int rowOfEachPage,
                                 @Param("filter") String filter);

    /**
     * @Author: yjf
     * @Description:
     * @Param: null
     * @Return: null
     * @Date: 11:56 2018/4/15
     */
    List<DriverPO> queryByFilter(String filter);

    /**
     * @Author: yjf
     * @Description: 查询司机总数
     * @Param: null
     * @Return: int
     * @Date: 11:56 2018/4/15
     */
    int driverCount();

    /**
     * @Author: yjf
     * @Description: 新增司机信息
     * @Param: DriverPO
     * @Return: null
     * @Date: 11:57 2018/4/15
     */
    void add(DriverPO driver);

    /**
     * @Author: yjf
     * @Description: 删除司机信息
     * @Param: id
     * @Return: null
     * @Date: 11:57 2018/4/15
     */
    void delete(int id);

    /**
     * @Author: yjf
     * @Description:更新司机信息
     * @Param: DriverPO
     * @Return: null
     * @Date: 11:58 2018/4/15
     */
    void update(DriverPO driver);
}
