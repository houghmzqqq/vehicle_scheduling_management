package com.example.vehicle_scheduling_management.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 17:28 2018/4/21
 * @modified by:
 */
public class OrdersPO implements Serializable{

    private int id;
    private String company;
    private String name;
    private String goodsName;
    private float weight;
    private float volume;
    private String province;
    private String city;
    private String detailedAddress;
    private Date createDate;
    private int types;
    private int isToBring;
    private int status;

    public OrdersPO() {
    }

    public OrdersPO(String company, String name, String goodsName, float weight, float volume, String province, String city, String detailedAddress, Date createDate, int status, int types, int isToBring) {
        this.company = company;
        this.name = name;
        this.goodsName = goodsName;
        this.weight = weight;
        this.volume = volume;
        this.province = province;
        this.city = city;
        this.detailedAddress = detailedAddress;
        this.createDate = createDate;
        this.types = types;
        this.isToBring = isToBring;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTypes() {
        return types;
    }

    public void setTypes(int types) {
        this.types = types;
    }

    public int getIsToBring() {
        return isToBring;
    }

    public void setIsToBring(int isToBring) {
        this.isToBring = isToBring;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersPO{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", name='" + name + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }
}
