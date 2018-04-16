package com.example.vehicle_scheduling_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.vehicle_scheduling_management.mapper")
public class VehicleSchedulingManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(VehicleSchedulingManagementApplication.class, args);
	}
}
