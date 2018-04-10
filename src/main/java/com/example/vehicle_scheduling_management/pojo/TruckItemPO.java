package com.example.vehicle_scheduling_management.pojo;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class TruckItemPO {
    private int id;
    private int scheduleId;
    private String plateNumber;
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
                ", plateNumber='" + plateNumber + '\'' +
                ", driverCode='" + driverCode + '\'' +
                ", driverName='" + driverName + '\'' +
                '}';
    }
}
