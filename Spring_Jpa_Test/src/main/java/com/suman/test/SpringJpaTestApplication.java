package com.suman.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringJpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaTestApplication.class, args);
	}

}
