package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.TruckMapper;
import com.example.vehicle_scheduling_management.pojo.TruckPO;
import com.example.vehicle_scheduling_management.service.TruckService;
import com.example.vehicle_scheduling_management.util.DivideUtil;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.TruckVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 20:37 2018/4/16
 * @modified by:
 */
@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    private TruckMapper truckMapper;

    @Autowired
    private DozerBeanMapper beanMapper;

    @Override
    public TruckVO queryById(int id) {
        TruckPO truckPO = truckMapper.queryById(id);

        return turnPoToVo(truckPO);
    }

    @Override
    public List<TruckVO> queryAll() {
        return null;
    }

    @Override
    public DividePageVO<TruckVO> divideQuery(int thisPage, int rowOfEachPage) {
        List<TruckPO> truckPOS = truckMapper.queryByDivide((thisPage-1)*rowOfEachPage,rowOfEachPage,null);
        List<TruckVO> truckVOS = new ArrayList<>();
        int pageCount = truckMapper.truckCount();
        DividePageVO<TruckVO> dividePage =
                new DivideUtil().getDividePageVO(thisPage,rowOfEachPage,pageCount);

        for(TruckPO truckPO : truckPOS){
            truckVOS.add(turnPoToVo(truckPO));
        }

        dividePage.setObjList(truckVOS);

        return dividePage;
    }

    @Override
    public void add(TruckVO truckVO) {
        TruckPO truckPO = new TruckPO();
        beanMapper.map(truckVO,truckPO);
        truckPO.setRecordDate(new Date());

        truckMapper.add(truckPO);
    }

    @Override
    public void delete(int id) {
        truckMapper.delete(id);
    }

    @Override
    public void update(TruckVO truckVO) {
        TruckPO truckPO = truckMapper.queryById(truckVO.getId());

        truckPO.setBrand(truckVO.getBrand());
        //more......

        truckMapper.update(truckPO);
    }

    public TruckVO turnPoToVo(TruckPO truckPO){
        TruckVO truckVO = new TruckVO();
        beanMapper.map(truckPO,truckVO);

        //将注册日期转换为String类型
        if (truckPO.getRecordDate()!=null && !"".equals(truckPO.getRecordDate())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            truckVO.setRecordDate(sdf.format(truckPO.getRecordDate()));
        }

        return truckVO;
    }
}
