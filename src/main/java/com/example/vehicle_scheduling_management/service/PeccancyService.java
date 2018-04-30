package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.PeccancyRecordVO;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 17:38 2018/4/30
 * @modified by:
 */
public interface PeccancyService {
    void add(PeccancyRecordVO peccancyRecordVO);

    void delete(int id);

    DividePageVO<PeccancyRecordVO> divideQuery(int thisPage, int rowOfEachPage);
}
