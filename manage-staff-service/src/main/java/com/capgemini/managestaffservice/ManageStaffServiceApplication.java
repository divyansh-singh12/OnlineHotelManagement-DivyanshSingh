package com.capgemini.managestaffservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManageStaffServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageStaffServiceApplication.class, args);
	}

}
