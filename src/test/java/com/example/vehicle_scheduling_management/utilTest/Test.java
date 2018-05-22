package com.example.vehicle_scheduling_management.utilTest;

import com.example.vehicle_scheduling_management.util.DateFormatUtil;
import com.example.vehicle_scheduling_management.util.MapUtil;
import com.example.vehicle_scheduling_management.util.UrlTool;
import net.sf.json.JSONArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/5/19.
 */
public class Test {

    @org.junit.Test
    public void test01() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = sdf.format(new Date());
        Date date = sdf.parse(dateStr);
        System.out.println(dateStr);
        System.out.println(date.toString());
    }

    @org.junit.Test
    public void test02() throws Exception {
        System.out.println(MapUtil.getDrivingPath(MapUtil.getLocation("广东省惠州市惠州学院")));
    }

    @org.junit.Test
    public void test03() throws Exception {
        System.out.println(MapUtil.getLocation("惠州市惠城区江北东江二路1号富力·丽港中心"));
    }

    @org.junit.Test
    public void test04() throws Exception {
        UrlTool urlTool = new UrlTool("http://a.amap.com/amap-ui/static/data/big-routes.json");
        String msg = urlTool.getResponseMsg();

        JSONArray jsonArray = JSONArray.fromObject(msg);
        for(int i=0;i<jsonArray.size();i++){
            System.out.println(jsonArray.get(i));
        }
    }
}
