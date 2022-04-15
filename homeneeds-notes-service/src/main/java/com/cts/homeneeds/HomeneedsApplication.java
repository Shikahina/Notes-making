package com.cts.homeneeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class HomeneedsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeneedsApplication.class, args);
	}

}
