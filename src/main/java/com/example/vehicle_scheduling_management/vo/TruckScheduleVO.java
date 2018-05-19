package com.example.vehicle_scheduling_management.vo;

import java.util.Date;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 11:58 2018/4/30
 * @modified by:
 */
public class TruckScheduleVO {
    private int id;
    private String startPlace;
    private String endPlace;
    private String span;
    private String aim;
    private String applicationState;
    private String applicationDate;
    private String accessDate;
    private String completeDate;
    private String status;
    private String remark;

    public TruckScheduleVO() {
    }

    public TruckScheduleVO(String startPlace, String endPlace, String span, String aim, String applicationState, String applicationDate, String accessDate, String status, String remark) {
        this.startPlace = startPlace;
        this.endPlace = endPlace;
        this.span = span;
        this.aim = aim;
        this.applicationState = applicationState;
        this.applicationDate = applicationDate;
        this.accessDate = accessDate;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public void setAccessDate(String accessDate) {
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
        return "TruckScheduleVO{" +
                "id=" + id +
                ", startPlace='" + startPlace + '\'' +
                ", endPlace='" + endPlace + '\'' +
                ", span='" + span + '\'' +
                ", aim='" + aim + '\'' +
                ", applicationState='" + applicationState + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", accessDate='" + accessDate + '\'' +
                ", completeDate='" + completeDate + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
