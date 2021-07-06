package com.example.pathservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PathServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathServiceApplication.class, args);
	}

}
