package com.example.vehicle_scheduling_management.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 叶俊锋 on 2018/5/11.
 */
public class HistoryTest {

    private UrlTool urlTool;

    /**
     * @Author: yjf
     * @Description: 获取路径规划
     * @Param: null
     * @Return: null
     * @Date: 10:31 2018/5/7
     */
    public String getWalking() throws Exception {
        String orgin = getLocation("惠州市河南岸汽车客运站");
        String destination = getLocation("惠州市惠城区东江二路1号富力国际大厦");

        System.out.println(orgin);
        System.out.println(destination);
//
//        System.out.println("orgin = " + orgin + ", destination = " + destination);

//        UrlTool urlTool2 = new UrlTool("http://restapi.amap.com/v4/direction/bicycling?key=a5adf042b0fb331d06dacd542469c1c8&origin=116.434307,39.90909&destination=116.434446,39.90816");

        urlTool = new UrlTool("http://restapi.amap.com/v3/direction/driving?key=a5adf042b0fb331d06dacd542469c1c8&" +
                "origin=" + orgin + "&destination=" + destination);
        String msg = urlTool.getResponseMsg();

        JSONObject res = JSONObject.fromObject(msg);
        JSONObject route = res.getJSONObject("route");
        JSONArray paths = route.getJSONArray("paths");

        JSONObject path0 = paths.getJSONObject(0);
        JSONArray steps = path0.getJSONArray("steps");

        System.out.println(steps.toString());

        return steps.toString();

    }

    /**
     * @Author: yjf
     * @Description: 获取地址坐标
     * @Param: address
     * @Return: String
     * @Date: 20:47 2018/5/5
     */
    public String getLocation(String address) throws Exception {
        String location = "";
        urlTool = new UrlTool("http://restapi.amap.com/v3/geocode/geo?" +
                "key=a5adf042b0fb331d06dacd542469c1c8&address=" + address);

        String msg = urlTool.getResponseMsg();

        JSONObject jsonObject = JSONObject.fromObject(msg);
        JSONArray geocodes = jsonObject.getJSONArray("geocodes");
        location = geocodes.getJSONObject(0).getString("location");

        return location;
    }

}
