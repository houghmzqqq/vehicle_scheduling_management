package com.example.vehicle_scheduling_management.pojo;

import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class HistoryPathPO {
    private int id;
    private int truckItemId;
    private Date times;
    private String longitude;
    private String latitude;
    private String location;

    public HistoryPathPO() {
    }

    public HistoryPathPO(int truckItemId, Date times, String longitude, String latitude, String location) {
        this.truckItemId = truckItemId;
        this.times = times;
        this.longitude = longitude;
        this.latitude = latitude;
        this.location = location;
    }

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

    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "HistoryPathPO{" +
                "id=" + id +
                ", truckItemId=" + truckItemId +
                ", times=" + times +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
