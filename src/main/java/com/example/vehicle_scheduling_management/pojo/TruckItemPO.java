package com.example.vehicle_scheduling_management.pojo;

import java.io.Serializable;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class TruckItemPO implements Serializable{
    private int id;
    private int scheduleId;
    private int truckId;
    private String plateNumber;
    private int driverId;
    private String driverCode;
    private String driverName;

    public TruckItemPO() {
    }

    public TruckItemPO(int scheduleId, String plateNumber, String driverCode, String driverName) {
        this.scheduleId = scheduleId;
        this.plateNumber = plateNumber;
        this.driverCode = driverCode;
        this.driverName = driverName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return "TruckItemPO{" +
                "id=" + id +
                ", scheduleId=" + scheduleId +
                ", truckId=" + truckId +
                ", plateNumber='" + plateNumber + '\'' +
                ", driver=" + driverId +
                ", driverCode='" + driverCode + '\'' +
                ", driverName='" + driverName + '\'' +
                '}';
    }
}
