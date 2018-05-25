package com.example.vehicle_scheduling_management.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class PeccancyRecordPO implements Serializable{
    private int id;
    private int truckItemId;
    private String plateNumber;
    private String driverCode;
    private String driverName;
    private Date peccancyDate;
    private String peccancyPlace;
    private String peccancy;
    private String result;
    private int deductPoints;
    private float fine;
    private String remark;

    public PeccancyRecordPO() {
    }

    public PeccancyRecordPO(int truckItemId, String plateNumber, String driverCode, String driverName, Date peccancyDate, String peccancyPlace, String peccancy, String result, int deductPoints, float fine, String remark) {
        this.truckItemId = truckItemId;
        this.plateNumber = plateNumber;
        this.driverCode = driverCode;
        this.driverName = driverName;
        this.peccancyDate = peccancyDate;
        this.peccancyPlace = peccancyPlace;
        this.peccancy = peccancy;
        this.result = result;
        this.deductPoints = deductPoints;
        this.fine = fine;
        this.remark = remark;
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

    public Date getPeccancyDate() {
        return peccancyDate;
    }

    public void setPeccancyDate(Date peccancyDate) {
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
        return "PeccancyRecordPO{" +
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
