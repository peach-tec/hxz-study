package com.hxz.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  // 开启Eureka
public class EurekaProviderDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaProviderDemoApplication.class, args);
    }
}
