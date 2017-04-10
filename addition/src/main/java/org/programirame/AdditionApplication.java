package org.programirame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdditionApplication.class, args);
	}
}
