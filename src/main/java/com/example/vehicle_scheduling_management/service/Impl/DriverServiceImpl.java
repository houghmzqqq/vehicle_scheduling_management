package com.example.vehicle_scheduling_management.service.Impl;

import com.example.vehicle_scheduling_management.mapper.DriverMapper;
import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.example.vehicle_scheduling_management.service.DriverService;
import com.example.vehicle_scheduling_management.util.DivideUtil;
import com.example.vehicle_scheduling_management.vo.DividePageVO;
import com.example.vehicle_scheduling_management.vo.DriverVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private DozerBeanMapper mapper;

    public DriverVO queryById(int id){
        DriverPO driverPO = driverMapper.queryById(id);
        return turnPoToVo(driverPO);
    }

    public List<DriverVO> queryAll(){
        List<DriverPO> driverPOS = driverMapper.queryAll();
        List<DriverVO> driverVOS = new ArrayList<>();


        for (DriverPO driverPO : driverPOS){
            //匹配po和vo
            driverVOS.add(turnPoToVo(driverPO));
        }
        return driverVOS;
    }

    @Override
    public DividePageVO<DriverVO> divideQuery(Integer thisPage, Integer rowOfEachPage) {
        List<DriverPO> driverPOS = driverMapper.queryByDivide((thisPage-1)*rowOfEachPage,rowOfEachPage,null);
        List<DriverVO> driverVOS = new ArrayList<>();
        int pageCount = driverMapper.driverCount();
        DividePageVO<DriverVO> dividePage =
                new DivideUtil().getDividePageVO(thisPage,rowOfEachPage,pageCount);


        for (DriverPO driverPO : driverPOS){
            //匹配po和vo
            driverVOS.add(turnPoToVo(driverPO));
        }

        dividePage.setObjList(driverVOS);

        return dividePage;
    }


    public void add(DriverVO driverVO) throws ParseException {
        DriverPO driverPO = new DriverPO();
        mapper.map(driverVO,driverPO);
        String date1 = driverVO.getGetLicenseDate();
        if (date1!=null && !"".equals(date1)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            driverPO.setGetLicenseDate(sdf.parse(date1));
        }
        driverPO.setState("4");
        System.out.println(driverPO);
        driverMapper.add(driverPO);
    }

    public void update(DriverVO driverVO){
//        driverMapper.update(driverPO);
        DriverPO driverPO = driverMapper.queryById(driverVO.getId());
        driverPO.setDriverName(driverVO.getDriverName());
        driverPO.setSex(driverVO.getSex());
        driverPO.setAge(driverVO.getAge());
        driverPO.setTellphone(driverVO.getTellphone());
        driverPO.setAddress(driverVO.getAddress());
        driverPO.setEmail(driverVO.getEmail());

        driverMapper.update(driverPO);
    }

    public void delete(int id){
        driverMapper.delete(id);
    }

    public DriverVO turnPoToVo(DriverPO driverPO){
        DriverVO driverVO = new DriverVO();
        mapper.map(driverPO,driverVO);
//            DriverVO driverVO = mapper.map(driverPO,DriverVO.class);
        if("0".equals(driverPO.getState()) ){
            driverVO.setState("跑单");
        }else if("1".equals(driverPO.getState()) ){
            driverVO.setState("休息");
        }else if("2".equals(driverPO.getState()) ){
            driverVO.setState("请假");
        }else if("3".equals(driverPO.getState()) ){
            driverVO.setState("离职");
        }else if("4".equals(driverPO.getState()) ){
            driverVO.setState("空闲");
        }
        if (driverPO.getGetLicenseDate()!=null && !"".equals(driverPO.getGetLicenseDate())){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            driverVO.setGetLicenseDate(sdf.format(driverPO.getGetLicenseDate()) );
        }
        return driverVO;
    }
}
