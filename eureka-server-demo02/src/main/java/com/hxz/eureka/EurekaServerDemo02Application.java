package com.hxz.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 开启Eureka主中心功能并启动
public class EurekaServerDemo02Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerDemo02Application.class, args);
    }
}
