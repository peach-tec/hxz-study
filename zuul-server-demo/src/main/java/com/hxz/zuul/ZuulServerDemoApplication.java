package com.hxz.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 开启Zuul代理
@EnableHystrixDashboard // 开启数据监控
public class ZuulServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerDemoApplication.class, args);
    }

}
