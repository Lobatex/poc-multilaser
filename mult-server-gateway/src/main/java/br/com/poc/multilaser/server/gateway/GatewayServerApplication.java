package br.com.poc.multilaser.server.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}
	
	
	@Bean
	 public RouteLocator customRouteLocator(RouteLocatorBuilder builder)  {
	 return builder.routes()
	  .route("path_route", r -> r.path("/cart/**").and().method("POST", "PUT", "DELETE").and().host("*")
	  .uri("http://localhost:8083"))
	  .build();
	 }

}
