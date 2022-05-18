package com.hxz.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 自定义全局过滤器
 * @copyright &copy; DYH
 * @date 2022-05-17-23:16
 * @address 成都
 */
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    /**
     * 过滤器执行的业务
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("执行自定义全局过滤器");
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行的顺序，数值约下，优先级越高
     */
    @Override
    public int getOrder() {
        return -1;
    }
}
