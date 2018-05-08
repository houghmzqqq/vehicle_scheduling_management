package com.example.vehicle_scheduling_management.util;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Author: yjf
 * @Description: 地图工具类，访问高德地图WebService
 * @Date: create in 11:14 2018/4/22
 * @modified by:
 */
public class MapUtil {

    private static UrlTool urlTool;
    public static final String COMPANY_LOCATION = "惠州市惠城区江北东江二路1号富力·国际中心";

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
     * @Description: 通过高德地图的webService获取路径规划(默认起始点)
     * @Param: destination
     * @Return: String
     * @Date: 11:05 2018/5/7
     */
    public synchronized static String getDirection(String destination){
        return getDirection("惠州市河南岸汽车客运站",destination);
    }
}
