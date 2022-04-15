package com.cts.homeneeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaClient
@EnableFeignClients("com.cts")
@SpringBootApplication
public class HomeNeedsUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeNeedsUsersApplication.class, args);
	}

}
