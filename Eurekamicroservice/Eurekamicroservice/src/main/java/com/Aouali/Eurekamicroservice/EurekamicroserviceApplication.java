package com.Aouali.Eurekamicroservice;

import jdk.jfr.Enabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekamicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekamicroserviceApplication.class, args);
	}
	@GetMapping
	public string hello(){
		return "hello";
	}

}
