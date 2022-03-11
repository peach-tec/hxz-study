package com.hxz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.hxz.mapper")
public class SpringbootMybatisMapperApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisMapperApplication.class, args);
    }

}
