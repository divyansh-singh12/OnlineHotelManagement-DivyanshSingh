package com.capgemini.manageguestservice;

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
public class ManageGuestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageGuestServiceApplication.class, args);
	}

}
