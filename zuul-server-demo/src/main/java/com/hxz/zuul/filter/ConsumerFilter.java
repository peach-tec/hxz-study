package com.hxz.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-05-01-22:59
 * @address 成都
 */
@Component
public class ConsumerFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(ConsumerFilter.class);

    /**
     * 过滤器类型：pre routing post error
     */
    @Override

    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 执行顺序，数值越小，优先级越高
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 执行条件 true-开启 false-关闭
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体操作
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        log.info("过滤器执行：  方法名：{}  url地址：{}", request.getMethod(), request.getRequestURL().toString());
        return null;
    }
}
