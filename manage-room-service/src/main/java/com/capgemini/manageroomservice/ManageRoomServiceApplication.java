package com.capgemini.manageroomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
public class ManageRoomServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageRoomServiceApplication.class, args);
	}

}
