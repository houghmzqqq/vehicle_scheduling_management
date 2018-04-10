package com.example.vehicle_scheduling_management.pojo;

import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class DriverPO {
    private int id;
    private String driverCode;
    private String name;
    private String sex;
    private int age;
    private String tellphone;
    private String email;
    private String address;
    private String drivingLicense;
    private int drivingAge;
    private String jobSeniorityNum;
    private Date getLicenseDate;
    private String state;

    public DriverPO() {
    }

    public DriverPO(String driverCode, String name, String sex, int age,
                    String tellphone, String email, String address,
                    String drivingLicense, int drivingAge, String jobSeniorityNum,
                    Date getLicenseDate, String state) {
        this.driverCode = driverCode;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tellphone = tellphone;
        this.email = email;
        this.address = address;
        this.drivingLicense = drivingLicense;
        this.drivingAge = drivingAge;
        this.jobSeniorityNum = jobSeniorityNum;
        this.getLicenseDate = getLicenseDate;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public int getDrivingAge() {
        return drivingAge;
    }

    public void setDrivingAge(int drivingAge) {
        this.drivingAge = drivingAge;
    }

    public String getJobSeniorityNum() {
        return jobSeniorityNum;
    }

    public void setJobSeniorityNum(String jobSeniorityNum) {
        this.jobSeniorityNum = jobSeniorityNum;
    }

    public Date getGetLicenseDate() {
        return getLicenseDate;
    }

    public void setGetLicenseDate(Date getLicenseDate) {
        this.getLicenseDate = getLicenseDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "DriverPO{" +
                "id=" + id +
                ", driverCode='" + driverCode + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tellphone='" + tellphone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", drivingAge=" + drivingAge +
                ", jobSeniorityNum='" + jobSeniorityNum + '\'' +
                ", getLicenseDate=" + getLicenseDate +
                ", state='" + state + '\'' +
                '}';
    }
}
