package com.example.vehicle_scheduling_management.vo;

import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class TruckVO {
    private int id;
    private String plateNumber;
    private String fleetName;
    private String brand;
    private String model;
    private String types;
    private String loads;
    private String colour;
    private String output;
    private int seat;
    private String recordDate;

    public TruckVO() {
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

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getLoads() {
        return loads;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setLoads(String loads) {
        this.loads = loads;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        return "TruckPO{" +
                "id=" + id +
                ", plateNumber='" + plateNumber + '\'' +
                ", fleetName='" + fleetName + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", types='" + types + '\'' +
                ", loads=" + loads +
                ", colour='" + colour + '\'' +
                ", output=" + output +
                ", seat=" + seat +
                ", recordDate=" + recordDate +
                '}';
    }
}
