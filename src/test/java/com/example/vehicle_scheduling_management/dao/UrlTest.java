package com.example.vehicle_scheduling_management.dao;

import com.example.vehicle_scheduling_management.util.UrlTool;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 11:41 2018/4/22
 * @modified by:
 */
public class UrlTest {

    private UrlTool urlTool;

    @Test
    public void test() throws Exception {
        //能够获取下级取域
        urlTool = new UrlTool("http://restapi.amap.com/v3/config/district?" +
                "key=a5adf042b0fb331d06dacd542469c1c8&keywords=惠州&subdistrict=0&" +
                "extensions=base");
        String msg = urlTool.getResponseMsg();
        StringBuilder stb = new StringBuilder(msg);
        stb.insert(0,'{');
        msg = stb.toString();

        JSONObject jsonObject = JSONObject.fromObject(msg);
        String districts = jsonObject.getString("districts");

        System.out.println(stb.toString());
        System.out.println(districts);
    }

    @Test
    public void test02() throws Exception {
        //获取坐标
        urlTool = new UrlTool("http://restapi.amap.com/v3/geocode/geo?" +
                "key=a5adf042b0fb331d06dacd542469c1c8&address=惠州市");
        String msg = urlTool.getResponseMsg();
        System.out.println(msg);
    }
}
