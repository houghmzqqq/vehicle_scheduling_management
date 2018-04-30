package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.AccidenceRecodeMapper;
import com.example.vehicle_scheduling_management.pojo.AccidenceRecodePO;
import com.example.vehicle_scheduling_management.pojo.TruckSchedulePO;
import com.example.vehicle_scheduling_management.service.AccidenceService;
import com.example.vehicle_scheduling_management.util.DivideUtil;
import com.example.vehicle_scheduling_management.vo.AccidenceRecodeVO;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.TruckScheduleVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 17:20 2018/4/30
 * @modified by:
 */
@Service
public class AccidenceServiceImpl implements AccidenceService {

    @Autowired
    private AccidenceRecodeMapper accidenceMapper;
    @Autowired
    private DozerBeanMapper beanMapper;
    @Autowired
    private DivideUtil divideUtil;


    @Override
    public void add(AccidenceRecodeVO accidenceRecodeVO) {
        accidenceMapper.add(this.turnVoToPo(accidenceRecodeVO));
    }

    @Override
    public void delete(int id) {
        accidenceMapper.delete(id);
    }

    @Override
    public DividePageVO<AccidenceRecodeVO> divideQuery(int thisPage, int rowOfEachPage) {
        List<AccidenceRecodePO> accidenceRecodePOS =
                accidenceMapper.queryByDivide((thisPage-1)*rowOfEachPage,rowOfEachPage);
        List<AccidenceRecodeVO> accidenceRecodeVOS = new ArrayList<>();
        int count = accidenceMapper.accidenceCount();
        DividePageVO<AccidenceRecodeVO> dividePage =
                divideUtil.getDividePageVO(thisPage,rowOfEachPage,count);

        for(AccidenceRecodePO accidenceRecodePO : accidenceRecodePOS){
            accidenceRecodeVOS.add(this.turnPoToVo(accidenceRecodePO));
        }

        dividePage.setObjList(accidenceRecodeVOS);

        return dividePage;

    }

    /**
     * @Author: yjf
     * @Description: Vo转换为Po
     * @Param: accidenceVO
     * @Return: AccidenceRecodePO
     * @Date: 17:31 2018/4/30
     */
    public AccidenceRecodePO turnVoToPo(AccidenceRecodeVO accidenceVO){
        AccidenceRecodePO accidencePO = new AccidenceRecodePO();
        beanMapper.map(accidenceVO,accidencePO);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(accidenceVO!=null && accidenceVO.getSignDate()!=null){
            try {
                accidencePO.setSignDate(sdf.parse(accidenceVO.getSignDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return accidencePO;
    }

    /**
     * @Author: yjf
     * @Description: Po转换为Vo
     * @Param: accidenceRecodePO
     * @Return: AccidenceRecodeVO
     * @Date: 17:37 2018/4/30
     */
    public AccidenceRecodeVO turnPoToVo(AccidenceRecodePO accidenceRecodePO){
        AccidenceRecodeVO accidenceRecodeVO = new AccidenceRecodeVO();
        beanMapper.map(accidenceRecodePO,accidenceRecodeVO);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(accidenceRecodePO!=null){
            accidenceRecodeVO.setSignDate(sdf.format(accidenceRecodePO.getSignDate()));
        }

        return accidenceRecodeVO;
    }
}
