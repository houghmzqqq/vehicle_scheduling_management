package com.example.vehicle_scheduling_management.pojo;

import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class TruckSchedulePO {
    private int id;
    private String startPlace;
    private String endPlace;
    private String span;
    private String aim;
    private String applicationState;
    private Date applicationDate;
    private Date accessDate;
    private String remark;

    public TruckSchedulePO() {
    }

    public TruckSchedulePO(String startPlace, String endPlace, String span, String aim, String applicationState, Date applicationDate, Date accessDate, String remark) {
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.span = span;
        this.aim = aim;
        this.applicationState = applicationState;
        this.applicationDate = applicationDate;
        this.accessDate = accessDate;
        this.remark = remark;
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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TruckSchedulePO{" +
                "id=" + id +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                ", span='" + span + '\'' +
                ", aim='" + aim + '\'' +
                ", applicationState='" + applicationState + '\'' +
                ", applicationDate=" + applicationDate +
                ", accessDate=" + accessDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
