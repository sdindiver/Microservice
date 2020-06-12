package com.concatenate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient; 

@SpringBootApplication 
@EnableEurekaClient
public class ConcatenateApp {

    public static void main(String[] args) {
        SpringApplication.run(ConcatenateApp.class, args);
    }
}
