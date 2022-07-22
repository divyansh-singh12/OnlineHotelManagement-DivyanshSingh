package com.capgemini.manageinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableEurekaClient
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class ManageInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageInventoryServiceApplication.class, args);
	}

}
