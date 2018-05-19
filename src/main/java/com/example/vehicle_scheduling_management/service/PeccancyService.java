package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.PeccancyRecordPO;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.PeccancyRecordVO;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 17:38 2018/4/30
 * @modified by:
 */
public interface PeccancyService {
    /**
     * @Author: yjf
     * @Description: 新增违章记录
     * @Param: peccancyRecordVO
     * @Param: scheId
     * @Param: driverId
     * @Param: truckId
     * @Return: null
     * @Date: 12:18 2018/5/19
     */
    String add(PeccancyRecordVO peccancyRecordVO,int scheId);

    void delete(int id);

    DividePageVO<PeccancyRecordVO> divideQuery(int thisPage, int rowOfEachPage);

    /**
     * @Author: yjf
     * @Description: 将VO转换为PO
     * @Param: peccancyRecordVO
     * @Return: nulPeccancyRecordPO
     * @Date: 12:34 2018/5/19
     */
    PeccancyRecordPO turnVoToPo(PeccancyRecordVO peccancyRecordVO);

}
