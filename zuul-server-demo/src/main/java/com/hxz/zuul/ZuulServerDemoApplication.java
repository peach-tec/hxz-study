package com.hxz.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 开启Zuul代理
public class ZuulServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerDemoApplication.class, args);
    }

}
