package com.laher.study.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.laher"})
public class DroolsDemoSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(DroolsDemoSpringApplication.class, args);
	}
}
