package com.hxz.zuul.ratelimit;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitUtils;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.support.DefaultRateLimitKeyGenerator;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 自定义限流器
 * @copyright &copy; DYH
 * @date 2022-05-02-23:05
 * @address 成都
 */
@Component
public class MyRateLimitKeyGenerator extends DefaultRateLimitKeyGenerator {
    public MyRateLimitKeyGenerator(RateLimitProperties properties, RateLimitUtils rateLimitUtils) {
        super(properties, rateLimitUtils);
    }

    @Override
    public String key(HttpServletRequest request, Route route, RateLimitProperties.Policy policy) {
        // 自定义限流器的原理是保持限流的key不一致
        return super.key(request, route, policy) + ":" + request.getParameter("id"); // 拼接上请求的参数为新的key
    }
}
