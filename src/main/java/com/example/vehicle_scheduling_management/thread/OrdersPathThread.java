package com.example.vehicle_scheduling_management.thread;

import com.example.vehicle_scheduling_management.util.MapUtil;
import net.sf.json.JSONObject;

import java.util.concurrent.Callable;

/**
 * @Author: yjf
 * @Description: 获取规划的路径信息
 * @Date: 9:19 2018/5/25
 */
public class OrdersPathThread implements Callable<String> {

    //目的地
    private String aimPlace;

    public OrdersPathThread (String aimPlace){
        this.aimPlace = aimPlace;
    }

    @Override
    public String call() throws Exception {
        String drivingPath = MapUtil.getDrivingPath(MapUtil.getLocation(aimPlace));
        JSONObject pathJson = JSONObject.fromObject(drivingPath);
        pathJson.accumulate("endPlace",aimPlace);

        return pathJson.toString();
    }


}
