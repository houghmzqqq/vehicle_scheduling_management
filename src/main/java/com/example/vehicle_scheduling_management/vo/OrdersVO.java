package com.example.vehicle_scheduling_management.vo;

import java.util.Date;

/**
 * @Author: yjf
 * @Description:
 * @Date: create in 23:10 2018/4/21
 * @modified by:
 */
public class OrdersVO {
    private int id;
    private String company;
    private String name;
    private String goodsName;
    private float weight;
    private float volume;
    private String province;
    private String city;
    private String detailedAddress;
    private String totalAddress;
    private String createDate;
    private String types;
    private String isToBring;
    private String status;

    public OrdersVO() {
    }

    public OrdersVO(String company, String name, String goodsName, float weight, float volume,
                    String province, String city, String detailedAddress, String totalAddress,
                    String createDate, String types, String isToBring, String status) {
        this.company = company;
        this.name = name;
        this.goodsName = goodsName;
        this.weight = weight;
        this.volume = volume;
        this.province = province;
        this.city = city;
        this.detailedAddress = detailedAddress;
        this.totalAddress = totalAddress;
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

    public String getTotalAddress() {
        return totalAddress;
    }

    public void setTotalAddress(String totalAddress) {
        this.totalAddress = totalAddress;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getIsToBring() {
        return isToBring;
    }

    public void setIsToBring(String isToBring) {
        this.isToBring = isToBring;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersVO{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", name='" + name + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", weight=" + weight +
                ", volume=" + volume +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", totalAddress='" + totalAddress + '\'' +
                ", createDate='" + createDate + '\'' +
                ", types='" + types + '\'' +
                ", isToBring='" + isToBring + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
