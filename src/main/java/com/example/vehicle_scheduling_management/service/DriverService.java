package com.example.vehicle_scheduling_management.service;

import com.example.vehicle_scheduling_management.mapper.DriverMapper;
import com.example.vehicle_scheduling_management.pojo.DriverPO;
import com.example.vehicle_scheduling_management.vo.DriverVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
@Service
public class DriverService {

    @Autowired
    private DriverMapper driverMapper;

    @Autowired
    private DozerBeanMapper mapper;

    public DriverPO queryById(int id){
        return driverMapper.queryById(id);
    }

    public List<DriverVO> queryAll(){
        List<DriverPO> driverPOS = driverMapper.queryAll();
        List<DriverVO> driverVOS = new ArrayList<>();
        for (DriverPO driverPO : driverPOS){
            //匹配po和vo
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            driverVO.setGetLicenseDate(sdf.format(driverPO.getGetLicenseDate()) );
            driverVOS.add(driverVO);
        }
        return driverVOS;
    }

    public void add(DriverPO driverPO){
        driverMapper.add(driverPO);
    }

    public void update(DriverPO driverPO){
        driverMapper.update(driverPO);
    }

    public void delete(int id){
        driverMapper.delete(id);
    }
}
