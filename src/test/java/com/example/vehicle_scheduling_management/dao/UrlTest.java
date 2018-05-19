package com.example.vehicle_scheduling_management.dao;

import com.example.vehicle_scheduling_management.mapper.HistoryPathMapper;
import com.example.vehicle_scheduling_management.pojo.HistoryPathPO;
import com.example.vehicle_scheduling_management.util.MapUtil;
import com.example.vehicle_scheduling_management.util.UrlTool;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 11:41 2018/4/22
 * @modified by:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
        "com.example.vehicle_scheduling_management.config",
        "com.example.vehicle_scheduling_management.action",
        "com.example.vehicle_scheduling_management.aspect",
        "com.example.vehicle_scheduling_management.filter"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class UrlTest {

    private UrlTool urlTool;

    @Autowired
    private HistoryPathMapper pathMapper;

    @Test
    public void test() throws Exception {
        //能够获取下级取域
        urlTool = new UrlTool("http://restapi.amap.com/v3/config/district?" +
                "key=a5adf042b0fb331d06dacd542469c1c8&keywords=惠州&subdistrict=0&" +
                "extensions=base");
        String msg = urlTool.getResponseMsg();

        JSONObject jsonObject = JSONObject.fromObject(msg);
        String districts = jsonObject.getString("districts");

        System.out.println(districts);
    }

    @Test
    public void test02() throws Exception {
        //获取坐标
        urlTool = new UrlTool("http://restapi.amap.com/v3/geocode/geo?" +
                "key=a5adf042b0fb331d06dacd542469c1c8&address=惠州市河南岸汽车客运站");
        String msg = urlTool.getResponseMsg();
        System.out.println(msg);
    }

    /**
     * @Author: yjf
     * @Description: 获取路径规划
     * @Param: null
     * @Return: null
     * @Date: 10:31 2018/5/7
     */
    @Test
    @Transactional
    @Rollback(false)
    public void getWalking() throws Exception {
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

        List<String> points = new ArrayList<>();
        String point[] = new String[2];
        for(int i=0;i<steps.size();i++){
            JSONObject step = (JSONObject) steps.get(i);
            String latAndLons[] = step.getString("polyline").split(";");
            for(int j=0;j<latAndLons.length;j++){
                String latAndLon[] = latAndLons[j].split(",");
//                point = "[" + latAndLon[0] + "," + latAndLon[1] + "]";
                point[0] = latAndLon[0];
                point[1] = latAndLon[1];
//                System.out.println("poi:" + point[0] + "," + point[1]);
                points.add(latAndLons[j]);
            }
        }

        HistoryPathPO pathPO = new HistoryPathPO();
        for (int i=0;i<points.size();i++){
            String poi[] = points.get(i).split(",");
            System.out.println("poi=" + poi[0] + "," + poi[1]);
            pathPO.setLatitude(poi[0]);
            pathPO.setLongitude(poi[1]);
            pathPO.setTruckItemId(10);
            pathPO.setLocation(getAddress(poi[0] + "," + poi[1]));
            pathMapper.add(pathPO);
        }

        System.out.println(points.toString());

//        return steps.toString();

    }

    /**
     * @Author: yjf
     * @Description: 地理逆编码
     * @Param: null
     * @Return: null
     * @Date: 12:50 2018/5/13
     */
    public String getAddress(String latAndLon) throws Exception {
        String url = "http://restapi.amap.com/v3/geocode/regeo?key=a5adf042b0fb331d06dacd542469c1c8&location="+latAndLon+
                "&extensions=base&batch=false&roadlevel=0";
        UrlTool urlTool = new UrlTool(url);
        String msg = urlTool.getResponseMsg();

        JSONObject jsonObject = JSONObject.fromObject(msg);
        String format_address = jsonObject.getJSONObject("regeocode").getString("formatted_address");

        return format_address;
    }

    @Test
    public void test06() throws Exception {
        System.out.println(getAddress("114.408752,23.106129"));
    }

    @Test
    public void test05() throws Exception {
        System.out.println(getAddress("114.423119,23.058958"));
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

    @Test
    public void test04(){
        String steps = MapUtil.getDirection("惠州市惠城区东江二路1号富力国际大厦");
        System.out.println(steps);
    }
}
