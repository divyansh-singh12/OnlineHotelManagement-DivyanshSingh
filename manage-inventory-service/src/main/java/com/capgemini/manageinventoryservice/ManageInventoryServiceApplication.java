package com.capgemini.manageinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManageInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageInventoryServiceApplication.class, args);
	}

}
