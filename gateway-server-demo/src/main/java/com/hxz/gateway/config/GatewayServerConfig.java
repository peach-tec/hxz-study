package com.hxz.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 配置类
 * @copyright &copy; DYH
 * @date 2022-05-17-22:46
 * @address 成都
 */
@Configuration
public class GatewayServerConfig {

    /**
     * 限流规则
     */
    @Bean
    public KeyResolver myKeyResolver() {
        // 根据请求地址限流
        // return exchange -> Mono.just(exchange.getRequest().getURI().getPath());

        // 根据指定参数限流,指定的参数必传,否则会抛出异常
        // return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("str"));

        // 根据IP限流
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    /**
     * 注册自定义的过滤器
     */
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//        return builder.routes().route("eureka-feign", r -> r
//                        .path("/list/**")
//                        .filters(f -> f.filter(new MyGatewayFilter()))
//                        .uri("lb://eureka-feign-demo")
//                )
//                .build();
//    }

    /**
     * 注册全局过滤器
     */
//    @Bean
//    public MyGlobalFilter myGlobalFilter() {
//        return new MyGlobalFilter();
//    }
}
