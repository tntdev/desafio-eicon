package com.eicon.project.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.eicon.project.model.repository")
@EntityScan("com.eicon.project.model.entity")
@Configuration
@ComponentScan(basePackages = {"com.eicon.project.controller", "com.eicon.project.service", "com.eicon.validation.*"})
@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

}
