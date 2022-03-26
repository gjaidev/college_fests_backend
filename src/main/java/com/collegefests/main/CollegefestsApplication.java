package com.collegefests.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(value = "com.collegefests.*")
@EntityScan(value = "com.collegefests.model")
@EnableJpaRepositories(value = "com.collegefests.repository")
public class CollegefestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegefestsApplication.class, args);
	}

}
