package com.wahaha.heyworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class HeyworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeyworldApplication.class, args);
    }

}
