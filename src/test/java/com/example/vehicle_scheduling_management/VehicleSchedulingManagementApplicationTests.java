package com.example.vehicle_scheduling_management;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = {"com.example.vehicle_scheduling_management.service.Impl",
		"com.example.vehicle_scheduling_management.config",
		"com.example.vehicle_scheduling_management.action",
		"com.example.vehicle_scheduling_management.aspect"})
@MapperScan(basePackages = {"com.example.vehicle_scheduling_management.mapper"})
public class VehicleSchedulingManagementApplicationTests {

	@Test
	public void contextLoads() {
	}

}
