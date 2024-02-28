package com.Microservice.apiGatewayService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.Microservice.apiGatewayService"})
public class main {

	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
	}

}
