package com.hxz.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaConsumerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerDemoApplication.class, args);
    }

}
