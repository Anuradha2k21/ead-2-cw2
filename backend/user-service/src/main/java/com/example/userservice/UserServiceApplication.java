package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

	@Bean
	@LoadBalanced
	public WebClient.Builder webclientBuilder(){
		return WebClient.builder();
	}
	@Bean
	public WebClient webclient(){
		return WebClient.builder().build();
	}
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
