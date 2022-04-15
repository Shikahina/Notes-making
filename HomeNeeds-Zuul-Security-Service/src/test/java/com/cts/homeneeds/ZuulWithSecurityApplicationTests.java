package com.cts.homeneeds;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.homeneeds.controllers.AuthController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ZuulWithSecurityApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private AuthController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	
	
}
