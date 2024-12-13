package com.golfclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.golfclub.models")
public class GolfClubApplication {
    public static void main(String[] args) {
        SpringApplication.run(GolfClubApplication.class, args);
    }
}
