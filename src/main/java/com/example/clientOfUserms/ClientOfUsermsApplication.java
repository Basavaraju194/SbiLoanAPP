package com.example.clientOfUserms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ClientOfUsermsApplication {

	@Autowired
	private WebClient webClient;


	@GetMapping("/users-client")
	public Mono getAllUsersFromUserms() {
		return webClient.get().uri("/users").retrieve()
				.toEntity(new ParameterizedTypeReference<List>() {
				});
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientOfUsermsApplication.class, args);
	}

}
