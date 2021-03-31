package br.com.poc.multilaser.application.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApplicationInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationInventoryApplication.class, args);
	}

}
