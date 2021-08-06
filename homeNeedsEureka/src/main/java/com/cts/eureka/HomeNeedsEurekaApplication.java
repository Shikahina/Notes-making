package com.cts.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HomeNeedsEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeNeedsEurekaApplication.class, args);
	}

}
