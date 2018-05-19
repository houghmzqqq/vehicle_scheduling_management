package com.example.vehicle_scheduling_management.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/5/16.
 */
public class DateFormatUtil {

    private static ThreadLocal<SimpleDateFormat> sdfLocal = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf;
        }
    };

    private static SimpleDateFormat sdf;

    public static String getDateFormatDay(Date oldDate){
        sdf = sdfLocal.get();
        try {
            return sdf.format(oldDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDateFormatTime(Date oldDate){
        sdfLocal.set(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        sdf = sdfLocal.get();
        try {
            return sdf.format(oldDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public static
}
