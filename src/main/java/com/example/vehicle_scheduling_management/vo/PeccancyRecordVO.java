package com.example.vehicle_scheduling_management.vo;

import java.util.Date;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 12:01 2018/4/30
 * @modified by:
 */
public class PeccancyRecordVO {
    private int id;
    private int truckItemId;
    private String plateNumber;
    private String driverCode;
    private String driverName;
    private String peccancyDate;
    private String peccancyPlace;
    private String peccancy;
    private String result;
    private int deductPoints;
    private float fine;
    private String remark;

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

    public String getPeccancyDate() {
        return peccancyDate;
    }

    public void setPeccancyDate(String peccancyDate) {
        this.peccancyDate = peccancyDate;
    }

    public String getPeccancyPlace() {
        return peccancyPlace;
    }

    public void setPeccancyPlace(String peccancyPlace) {
        this.peccancyPlace = peccancyPlace;
    }

    public String getPeccancy() {
        return peccancy;
    }

    public void setPeccancy(String peccancy) {
        this.peccancy = peccancy;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getDeductPoints() {
        return deductPoints;
    }

    public void setDeductPoints(int deductPoints) {
        this.deductPoints = deductPoints;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "PeccancyRecordVO{" +
                "id=" + id +
                ", truckItemId=" + truckItemId +
                ", plateNumber='" + plateNumber + '\'' +
                ", driverCode='" + driverCode + '\'' +
                ", driverName='" + driverName + '\'' +
                ", peccancyDate=" + peccancyDate +
                ", peccancyPlace='" + peccancyPlace + '\'' +
                ", peccancy='" + peccancy + '\'' +
                ", result='" + result + '\'' +
                ", deductPoints=" + deductPoints +
                ", fine=" + fine +
                ", remark='" + remark + '\'' +
                '}';
    }
}
