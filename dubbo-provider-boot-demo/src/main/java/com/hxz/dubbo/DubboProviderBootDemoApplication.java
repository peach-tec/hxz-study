package com.hxz.dubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo // 开启dubbo功能
public class DubboProviderBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderBootDemoApplication.class, args);
	}

}
