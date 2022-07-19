package com.capgemini.managedepartmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties
public class ManageDepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageDepartmentServiceApplication.class, args);
	}

}
