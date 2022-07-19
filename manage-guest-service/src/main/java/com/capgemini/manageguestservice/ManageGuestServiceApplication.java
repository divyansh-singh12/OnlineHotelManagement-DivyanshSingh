package com.capgemini.manageguestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManageGuestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageGuestServiceApplication.class, args);
	}

}
