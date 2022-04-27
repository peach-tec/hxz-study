package com.hxz.eureka;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients //开启feign功能
public class EurekaFeignDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignDemoApplication.class, args);
    }

    /**
     * Feign远程调用日志记录
     */
    @Bean
    public Logger.Level level() {
        /**
         * NONE：不记录任何值，默认
         * BASIC：记录请求方法、请求URL、状态码和用时
         * HEADERS：在BASIC的基础上在记录一些常用的信息
         * FULL：记录请求和响应的所有信息
         */
        return Logger.Level.FULL;
    }
}
