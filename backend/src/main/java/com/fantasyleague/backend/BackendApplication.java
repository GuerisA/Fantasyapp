package com.fantasyleague.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.fantasyleague.backend")
@SpringBootApplication(scanBasePackages = "com.fantasyleague.backend")
@EntityScan(basePackages = "com.fantasyleague.backend.model")
@EnableJpaRepositories(basePackages = "com.fantasyleague.backend.repository")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
