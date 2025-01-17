package com.Exercitiul1.Laborator9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Laborator9Application {

	public static void main(String[] args) {
		SpringApplication.run(Laborator9Application.class, args);
	}
	@Bean
	public DatabaseInitializer databaseInitializer(JdbcTemplate jdbcTemplate) {
		return new DatabaseInitializer(jdbcTemplate);
	}

}
