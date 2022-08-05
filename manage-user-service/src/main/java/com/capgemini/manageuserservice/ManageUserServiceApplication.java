package com.capgemini.manageuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan
@EnableAutoConfiguration
public class ManageUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageUserServiceApplication.class, args);
	}

}