package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryProyectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryProyectServiceApplication.class, args);
	}

}
