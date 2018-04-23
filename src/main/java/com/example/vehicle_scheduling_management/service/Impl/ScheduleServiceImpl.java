package com.example.vehicle_scheduling_management.service.Impl;


import com.example.vehicle_scheduling_management.service.ScheduleService;
import com.example.vehicle_scheduling_management.util.UrlTool;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 19:50 2018/4/23
 * @modified by:
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private JSONObject jsonObject;

    @Override
    public void createSchedule(int driverId, int truckId, int orderId) {

    }

    @Override
    public String getLocalPosition() {
        String position = "";
        try {
            UrlTool urlTool = new UrlTool("http://restapi.amap.com/v3/geocode/geo?" +
                    "key=a5adf042b0fb331d06dacd542469c1c8&address=惠州市惠城区河南岸公园小区");
            StringBuilder sb = new StringBuilder(urlTool.getResponseMsg());
            sb.insert(0,'{');

            jsonObject = JSONObject.fromObject(sb.toString());

            JSONArray jsonArray = jsonObject.getJSONArray("geocodes");
            jsonObject = jsonArray.getJSONObject(0);
            position = jsonObject.getString("location");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }
}
