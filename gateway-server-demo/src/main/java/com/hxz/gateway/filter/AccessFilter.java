package com.hxz.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 权限验证过滤器
 * @copyright &copy; DYH
 * @date 2022-05-17-23:28
 * @address 成都
 */
@Component
public class AccessFilter implements GlobalFilter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 权限验证逻辑
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = null;
        // 获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        // 获取请求头中的token
        token = request.getHeaders().getFirst("token");
        if (!StringUtils.hasText(token)) { // 为空就从参数中获取
            token = request.getQueryParams().getFirst("token");
        }
        // token不存在的逻辑
        if (!StringUtils.hasText(token)) {
            log.error("token 不存在...");
            // 响应对象
            ServerHttpResponse response = exchange.getResponse();
            // 设置响应信息
            response.getHeaders().add("Content-Type", "application/json; charset=UTF-8");
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            String message = "{\"message\":\"未认证无法访问\"}";
            DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());
            return response.writeWith(Mono.just(buffer));
        }
        // token 存在执行验证逻辑
        log.info("验证通过");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
