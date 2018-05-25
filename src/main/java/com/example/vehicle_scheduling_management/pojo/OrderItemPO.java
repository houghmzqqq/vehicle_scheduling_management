package com.example.vehicle_scheduling_management.pojo;

import java.io.Serializable;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class OrderItemPO implements Serializable{
    private int id;
    private int scheduleId;
    private int orderId;

    public OrderItemPO() {
    }

    public OrderItemPO(int scheduleId, int orderId) {
        this.scheduleId = scheduleId;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderItemPO{" +
                "id=" + id +
                ", scheduleId=" + scheduleId +
                ", orderId=" + orderId +
                '}';
    }
}
