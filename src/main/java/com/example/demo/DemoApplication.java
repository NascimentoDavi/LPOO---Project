package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class DemoApplication {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @jakarta.annotation.PostConstruct
    public void init() {
        System.out.println("MongoDB URI: " + mongoUri);
    }
}
