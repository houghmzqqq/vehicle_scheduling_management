package com.example.vehicle_scheduling_management.pojo;

import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class AccidenceRecodePO {
    private int id;
    private String plateNumber;
    private String driverCode;
    private String driverName;
    private float cost;
    private float insuranceCost;
    private float companyPay;
    private int injured;
    private int dead;
    private float guyPay;
    private String guyName;
    private String guyIdentity;
    private String guyAddress;
    private String guyTellphone;
    private String guyPlateNumber;
    private String guyCartType;
    private String accidentPlace;
    private String anlysis;
    private Date signDate;
    private String handleResult;
    private String operator;
    private String remark;
    private int truckItemId;

    public AccidenceRecodePO() {
    }

    public AccidenceRecodePO(String plateNumber, String driverCode, String driverName, float cost, float insuranceCost, float companyPay, int injured, int dead, float guyPay, String guyName, String guyIdentity, String guyAddress, String guyTellphone, String guyPlateNumber, String guyCartType, String accidentPlace, String anlysis, Date signDate, String handleResult, String operator, String remark, int truckItemId) {
        this.plateNumber = plateNumber;
        this.driverCode = driverCode;
        this.driverName = driverName;
        this.cost = cost;
        this.insuranceCost = insuranceCost;
        this.companyPay = companyPay;
        this.injured = injured;
        this.dead = dead;
        this.guyPay = guyPay;
        this.guyName = guyName;
        this.guyIdentity = guyIdentity;
        this.guyAddress = guyAddress;
        this.guyTellphone = guyTellphone;
        this.guyPlateNumber = guyPlateNumber;
        this.guyCartType = guyCartType;
        this.accidentPlace = accidentPlace;
        this.anlysis = anlysis;
        this.signDate = signDate;
        this.handleResult = handleResult;
        this.operator = operator;
        this.remark = remark;
        this.truckItemId = truckItemId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(float insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public float getCompanyPay() {
        return companyPay;
    }

    public void setCompanyPay(float companyPay) {
        this.companyPay = companyPay;
    }

    public int getInjured() {
        return injured;
    }

    public void setInjured(int injured) {
        this.injured = injured;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public float getGuyPay() {
        return guyPay;
    }

    public void setGuyPay(float guyPay) {
        this.guyPay = guyPay;
    }

    public String getGuyName() {
        return guyName;
    }

    public void setGuyName(String guyName) {
        this.guyName = guyName;
    }

    public String getGuyIdentity() {
        return guyIdentity;
    }

    public void setGuyIdentity(String guyIdentity) {
        this.guyIdentity = guyIdentity;
    }

    public String getGuyAddress() {
        return guyAddress;
    }

    public void setGuyAddress(String guyAddress) {
        this.guyAddress = guyAddress;
    }

    public String getGuyTellphone() {
        return guyTellphone;
    }

    public void setGuyTellphone(String guyTellphone) {
        this.guyTellphone = guyTellphone;
    }

    public String getGuyPlateNumber() {
        return guyPlateNumber;
    }

    public void setGuyPlateNumber(String guyPlateNumber) {
        this.guyPlateNumber = guyPlateNumber;
    }

    public String getGuyCartType() {
        return guyCartType;
    }

    public void setGuyCartType(String guyCartType) {
        this.guyCartType = guyCartType;
    }

    public String getAccidentPlace() {
        return accidentPlace;
    }

    public void setAccidentPlace(String accidentPlace) {
        this.accidentPlace = accidentPlace;
    }

    public String getAnlysis() {
        return anlysis;
    }

    public void setAnlysis(String anlysis) {
        this.anlysis = anlysis;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getTruckItemId() {
        return truckItemId;
    }

    public void setTruckItemId(int truckItemId) {
        this.truckItemId = truckItemId;
    }

    @Override
    public String toString() {
        return "AccidenceRecodePO{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", driverCode='" + driverCode + '\'' +
                ", driverName='" + driverName + '\'' +
                ", cost=" + cost +
                ", insuranceCost=" + insuranceCost +
                ", companyPay=" + companyPay +
                ", injured=" + injured +
                ", dead=" + dead +
                ", guyPay=" + guyPay +
                ", guyName='" + guyName + '\'' +
                ", guyIdentity='" + guyIdentity + '\'' +
                ", guyAddress='" + guyAddress + '\'' +
                ", guyTellphone='" + guyTellphone + '\'' +
                ", guyPlateNumber='" + guyPlateNumber + '\'' +
                ", guyCartType='" + guyCartType + '\'' +
                ", accidentPlace='" + accidentPlace + '\'' +
                ", anlysis='" + anlysis + '\'' +
                ", signDate=" + signDate +
                ", handleResult='" + handleResult + '\'' +
                ", operator='" + operator + '\'' +
                ", remark='" + remark + '\'' +
                ", truckItemId=" + truckItemId +
                '}';
    }
}
