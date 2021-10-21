package com.stuffed.animal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.map.repository.config.EnableMapRepositories;

@SpringBootApplication
@EnableMapRepositories
public class StuffedAnimalSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuffedAnimalSystemApplication.class, args);
    }
}
