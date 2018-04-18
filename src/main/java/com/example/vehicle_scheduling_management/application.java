package com.example.vehicle_scheduling_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by 叶俊锋 on 2018/4/18.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
        "com.example.vehicle_scheduling_management.config",
        "com.example.vehicle_scheduling_management.action",
        "com.example.vehicle_scheduling_management.aspect"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class application {
    public static void main(String[] args) {
        SpringApplication.run(VehicleSchedulingManagementApplication.class, args);
    }
}
