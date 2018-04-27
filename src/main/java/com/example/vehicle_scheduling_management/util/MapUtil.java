package com.example.vehicle_scheduling_management.util;


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
    public static String getLocation(String keyWords) throws Exception {
        urlTool = new UrlTool("http://restapi.amap.com/v3/geocode/geo?" +
                "key=a5adf042b0fb331d06dacd542469c1c8&address=惠州市惠城区江北东江二路1号富力·国际中心");
        String msg = urlTool.getResponseMsg();
        System.out.println(msg);
        return null;
    }

}
