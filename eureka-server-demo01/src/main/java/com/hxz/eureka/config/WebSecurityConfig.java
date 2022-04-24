package com.hxz.eureka.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 安全认证配置
 * @copyright &copy; DYH
 * @date 2022-04-24-23:25
 * @address 成都
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http); // 访问eureka控制台时能做安全控制
        http.csrf().ignoringAntMatchers("/eureka/**"); // 忽略 /eureka/** 的所有请求
    }
}
