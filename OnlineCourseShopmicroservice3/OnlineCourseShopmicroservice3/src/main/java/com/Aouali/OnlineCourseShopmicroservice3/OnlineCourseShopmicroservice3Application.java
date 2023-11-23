package com.Aouali.OnlineCourseShopmicroservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OnlineCourseShopmicroservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCourseShopmicroservice3Application.class, args);
	}

}
