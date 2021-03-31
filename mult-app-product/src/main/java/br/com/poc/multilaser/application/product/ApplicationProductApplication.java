package br.com.poc.multilaser.application.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationProductApplication.class, args);
	}

}
