package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PersonalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalServiceApplication.class, args);
	}

}
