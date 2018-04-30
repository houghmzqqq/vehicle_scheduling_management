package com.example.vehicle_scheduling_management.mapper;

import com.example.vehicle_scheduling_management.pojo.AccidenceRecodePO;
import com.example.vehicle_scheduling_management.pojo.TruckSchedulePO;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/11.
 */
@Repository
public interface AccidenceRecodeMapper {
    AccidenceRecodePO queryById(int id);

    /**
     * @Author: yjf
     * @Description: 分页查询
     * @Param: null
     * @Return: null
     * @Date: 13:28 2018/4/30
     */
    List<AccidenceRecodePO> queryByDivide(@Param("firstData") int firstData,
                                          @Param("rowOfEachPage") int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 查询总数
     * @Param: null
     * @Return: int
     * @Date: 13:28 2018/4/30
     */
    int accidenceCount();

    void add(AccidenceRecodePO accidenceRecodePO);

    void delete(int id);

    void update(AccidenceRecodePO accidenceRecodePO);
}
