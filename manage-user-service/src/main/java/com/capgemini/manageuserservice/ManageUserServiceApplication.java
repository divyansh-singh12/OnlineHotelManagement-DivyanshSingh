package com.capgemini.manageuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManageUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageUserServiceApplication.class, args);
	}

}
