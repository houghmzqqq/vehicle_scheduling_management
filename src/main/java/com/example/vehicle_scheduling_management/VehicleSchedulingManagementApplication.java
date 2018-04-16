package com.example.vehicle_scheduling_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
		"com.example.vehicle_scheduling_management.config",
		"com.example.vehicle_scheduling_management.action"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class VehicleSchedulingManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(VehicleSchedulingManagementApplication.class, args);
	}
}

