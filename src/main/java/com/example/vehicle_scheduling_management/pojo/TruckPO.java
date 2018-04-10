package com.example.vehicle_scheduling_management.pojo;

import java.util.Date;

/**
 * Created by 叶俊锋 on 2018/4/10.
 */
public class TruckPO {
    private int id;
    private String plateNumber;
    private String fleetName;
    private String brand;
    private String model;
    private String types;
    private int loads;
    private String colour;
    private int output;
    private int seat;
    private Date recordDate;

    public TruckPO() {
    }

    public TruckPO(String plateNumber, String fleetName, String brand, String model, String types, int loads, String colour, int output, int seat, Date recordDate) {
        this.plateNumber = plateNumber;
        this.fleetName = fleetName;
        this.brand = brand;
        this.model = model;
        this.types = types;
        this.loads = loads;
        this.colour = colour;
        this.output = output;
        this.seat = seat;
        this.recordDate = recordDate;
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

    public int getLoads() {
        return loads;
    }

    public void setLoads(int loads) {
        this.loads = loads;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
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
