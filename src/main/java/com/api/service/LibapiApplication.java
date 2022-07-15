package com.api.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LibapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibapiApplication.class, args);
    }


}
