package com.example.vehicle_scheduling_management.vo;

import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/5/16.
 */
public class HistoryPathVO {
    private int id;
    private int truckItemId;
    private String times;
    private String longitude;
    private String location;
    private String latitude;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTruckItemId() {
        return truckItemId;
    }

    public void setTruckItemId(int truckItemId) {
        this.truckItemId = truckItemId;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "HistoryPathVO{" +
                "id=" + id +
                ", truckItemId=" + truckItemId +
                ", times='" + times + '\'' +
                ", longitude='" + longitude + '\'' +
                ", location='" + location + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
