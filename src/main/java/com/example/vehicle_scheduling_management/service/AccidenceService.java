package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.pojo.AccidenceRecodePO;
import com.example.vehicle_scheduling_management.vo.AccidenceRecodeVO;
import com.example.vehicle_scheduling_management.vo.DividePageVO;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 13:51 2018/4/30
 * @modified by:
 */
public interface AccidenceService {
    void add(AccidenceRecodeVO accidenceRecodeVO);

    void delete(int id);

    DividePageVO<AccidenceRecodeVO> divideQuery(int thisPage, int rowOfEachPage);


}
