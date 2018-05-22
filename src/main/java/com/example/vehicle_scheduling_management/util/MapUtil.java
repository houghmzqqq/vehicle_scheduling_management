package com.example.vehicle_scheduling_management.util;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yjf
 * @Description: 地图工具类，访问高德地图WebService
 * @Date: create in 11:14 2018/4/22
 * @modified by:
 */
public class MapUtil {

    private static UrlTool urlTool;
    public static final String COMPANY_LOCATION = "惠州市惠城区江北东江二路1号富力·丽港中心";


    /**
     * @Author: yjf
     * @Description: 获取指定地点的坐标
     * @Param: keyWords
     * @Return: String
     * @Date: 10:40 2018/4/23
     */
    public synchronized static String getLocation(String keyWords) throws Exception {
        String location = "";
        urlTool = new UrlTool("http://restapi.amap.com/v3/geocode/geo?" +
                "key=a5adf042b0fb331d06dacd542469c1c8&address=" + keyWords);
        String msg = urlTool.getResponseMsg();

        JSONObject jsonObject = JSONObject.fromObject(msg);
        JSONArray geocodes = jsonObject.getJSONArray("geocodes");
        location = geocodes.getJSONObject(0).getString("location");

        return location;
    }

    /**
     * @Author: yjf
     * @Description: 通过高德地图的webService获取路径规划
     * @Param: origin
     * @Param: destination
     * @Return: String
     * @Date: 11:05 2018/5/7
     */
    public synchronized static String getDirection(String origin, String destination){
        try {
            String originLoca = getLocation(origin);
            String destinLoca = getLocation(destination);
            urlTool = new UrlTool("http://restapi.amap.com/v3/direction/driving?key=a5adf042b0fb331d06dacd542469c1c8&" +
                    "origin=" + originLoca + "&destination=" + destinLoca);
            String msg = urlTool.getResponseMsg();

            JSONObject res = JSONObject.fromObject(msg);
            JSONObject route = res.getJSONObject("route");
            JSONArray paths = route.getJSONArray("paths");

            JSONObject path0 = paths.getJSONObject(0);
            JSONArray steps = path0.getJSONArray("steps");

            return steps.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: yjf
     * @Description: 根据起始地，获取路径规划
     * @Param: orgin
     * @Param: destination
     * @Return: String
     * @Date: 9:24 2018/5/21
     */
    public synchronized static String getDrivingPath(String orgin,String destination) throws Exception {
        urlTool = new UrlTool("http://restapi.amap.com/v3/direction/driving?key=a5adf042b0fb331d06dacd542469c1c8&" +
                "origin=" + orgin + "&destination=" + destination);
        String msg = urlTool.getResponseMsg();

        JSONObject res = JSONObject.fromObject(msg);
        JSONObject route = res.getJSONObject("route");
        JSONArray paths = route.getJSONArray("paths");

        JSONObject path0 = paths.getJSONObject(0);
        JSONArray steps = path0.getJSONArray("steps");

        List<String[]> points = new ArrayList<>();
        for(int i=0;i<steps.size();i++){
            JSONObject step = (JSONObject) steps.get(i);
            String latAndLons[] = step.getString("polyline").split(";");
            for(int j=0;j<latAndLons.length;j++){
                String latAndLon[] = latAndLons[j].split(",");
//                point = "[" + latAndLon[0] + "," + latAndLon[1] + "]";

                points.add(latAndLon);
            }
        }

        JSONArray poisJson = JSONArray.fromObject(points);

        path0.put("steps",poisJson);
        route.put("paths",path0);
        res.put("route",route);
//        path0.accumulate("steps",poisJson);
//        route.accumulate("paths",path0);
//        res.accumulate("route",route);

        return res.toString();
    }

    /**
     * @Author: yjf
     * @Description: 根据目的地规划路线
     * @Param: destination
     * @Return: String
     * @Date: 9:46 2018/5/21
     */
    public synchronized static String getDrivingPath(String destination) throws Exception {
        return getDrivingPath(getLocation(COMPANY_LOCATION),destination);
    }

    /**
     * @Author: yjf
     * @Description: 通过高德地图的webService获取路径规划(默认起点)
     * @Param: destination
     * @Return: String
     * @Date: 11:05 2018/5/7
     */
    public synchronized static String getDirection(String destination){
        return getDirection(COMPANY_LOCATION,destination);
    }
}
