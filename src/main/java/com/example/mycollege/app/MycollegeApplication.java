package com.example.mycollege.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.mycollege")
@EntityScan("com.example.mycollege.model")
@EnableJpaRepositories({"com.example.mycollege.dao.impl", "com.example.mycollege.repository"})
public class MycollegeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycollegeApplication.class, args);
	}

}
