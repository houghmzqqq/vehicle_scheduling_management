package com.example.vehicle_scheduling_management.vo;

/**
 * Created by 叶俊锋 on 2018/5/8.
 */
public class TruckScheduleShVO {
    private int id;
    private String startPlace;
    private String endPlace;
    private String span;
    private String aim;
    private String applicationState;
    private String applicationDate;
    private String accessDate;
    private String status;
    private String remark;

    //司机
    private int driverId;
    private String driverName;
    //货车
    private int truckId;
    private String plateNumber;
    //订单
    private int orderId;
    private String company;

    public TruckScheduleShVO() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public String getSpan() {
        return span;
    }

    public void setSpan(String span) {
        this.span = span;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(String applicationState) {
        this.applicationState = applicationState;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(String accessDate) {
        this.accessDate = accessDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getTruckId() {
        return truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "TruckScheduleShVO{" +
                "id=" + id +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                ", span='" + span + '\'' +
                ", aim='" + aim + '\'' +
                ", applicationState='" + applicationState + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", accessDate='" + accessDate + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", truckId=" + truckId +
                ", plateNumber='" + plateNumber + '\'' +
                ", orderId=" + orderId +
                ", company='" + company + '\'' +
                '}';
    }
}
