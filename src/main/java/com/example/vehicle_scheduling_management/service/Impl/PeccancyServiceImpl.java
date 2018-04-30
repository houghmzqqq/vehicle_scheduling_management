package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.PeccancyRecordMapper;
import com.example.vehicle_scheduling_management.pojo.PeccancyRecordPO;
import com.example.vehicle_scheduling_management.service.PeccancyService;
import com.example.vehicle_scheduling_management.util.DivideUtil;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.PeccancyRecordVO;
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
 * @Date: create in 17:39 2018/4/30
 * @modified by:
 */
@Service
public class PeccancyServiceImpl implements PeccancyService {

    @Autowired
    private PeccancyRecordMapper peccancyMapper;
    @Autowired
    private DozerBeanMapper beanMapper;
    @Autowired
    private DivideUtil divideUtil;

    @Override
    public void add(PeccancyRecordVO peccancyRecordVO) {
        peccancyMapper.add(turnVoToPo(peccancyRecordVO));
    }

    @Override
    public void delete(int id) {
        peccancyMapper.delete(id);
    }

    @Override
    public DividePageVO<PeccancyRecordVO> divideQuery(int thisPage, int rowOfEachPage) {
        List<PeccancyRecordPO> peccancyRecordPOS =
                peccancyMapper.queryByDivide((thisPage-1)*rowOfEachPage,rowOfEachPage);
        List<PeccancyRecordVO> peccancyRecordVOS = new ArrayList<>();
        int count = peccancyMapper.peccancyCount();
        DividePageVO<PeccancyRecordVO> dividePage =
                divideUtil.getDividePageVO(thisPage,rowOfEachPage,count);

        for(PeccancyRecordPO peccancyRecordPO : peccancyRecordPOS){
            peccancyRecordVOS.add(turnPoToVo(peccancyRecordPO));
        }

        dividePage.setObjList(peccancyRecordVOS);
        return dividePage;
    }

    /**
     * @Author: yjf
     * @Description: Po转换为Vo
     * @Param: peccancyRecordPO
     * @Return: PeccancyRecordVO
     * @Date: 17:46 2018/4/30
     */
    public PeccancyRecordVO turnPoToVo(PeccancyRecordPO peccancyRecordPO){
        PeccancyRecordVO peccancyRecordVO = new PeccancyRecordVO();
        beanMapper.map(peccancyRecordPO,peccancyRecordVO);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(peccancyRecordPO!=null){
            peccancyRecordVO.setPeccancyDate(sdf.format(peccancyRecordPO.getPeccancyDate()));
        }

        return peccancyRecordVO;
    }

    /**
     * @Author: yjf
     * @Description: Vo转换为Po
     * @Param: peccancyRecordVO
     * @Return: PeccancyRecordPO
     * @Date: 17:46 2018/4/30
     */
    public PeccancyRecordPO turnVoToPo(PeccancyRecordVO peccancyRecordVO){
        PeccancyRecordPO peccancyRecordPO = new PeccancyRecordPO();
        beanMapper.map(peccancyRecordVO,peccancyRecordPO);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        if(peccancyRecordVO!=null){
            try {
                peccancyRecordPO.setPeccancyDate(sdf.parse(peccancyRecordVO.getPeccancyDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return peccancyRecordPO;
    }
}
