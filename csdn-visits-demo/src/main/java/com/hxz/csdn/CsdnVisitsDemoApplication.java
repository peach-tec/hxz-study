package com.hxz.csdn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class CsdnVisitsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsdnVisitsDemoApplication.class, args);
    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }
}
