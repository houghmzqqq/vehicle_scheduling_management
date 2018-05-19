package com.example.vehicle_scheduling_management.utilTest;

import com.example.vehicle_scheduling_management.util.DateFormatUtil;

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
}
