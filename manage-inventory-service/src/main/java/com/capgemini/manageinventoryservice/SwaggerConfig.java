package com.capgemini.manageinventoryservice;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.capgemini.manageinventoryservice.controller"))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apidetails());
	}

	private ApiInfo apidetails() {
		return new ApiInfo("Manage Inventory", "It manages all the inventory present in the Hotel.", "1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Divyansh Singh",
						"http://localhost:8082/ManageInventory/HelloTest", "silentknight1010@gmail.com"),
				"API Licence", "http://localhost:8082", Collections.emptyList());
	}

}

// http://localhost:8082/v2/api-docs
// http://localhost:8082/swagger-ui/index.html#/
