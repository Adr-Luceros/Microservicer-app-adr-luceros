package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PickingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickingServiceApplication.class, args);
	}

	//@Bean
	//public RestTemplate restTemplate() {
	//	return new RestTemplate();
	//}
}
