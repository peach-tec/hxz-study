package com.hxz.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-05-02-22:12
 * @address 成都
 */
@Component
public class ErrorFilter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(ErrorFilter.class);

    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletResponse response = context.getResponse();
        ZuulException exception = this.zuulException(context.getThrowable());
        HttpStatus status = null;
        if (429 == exception.nStatusCode) {
            status = HttpStatus.TOO_MANY_REQUESTS;
        }
        if (500 == exception.nStatusCode) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            // 此处自定义响应体end
            response.setStatus(status.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getOutputStream().write(status.getReasonPhrase().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param e 异常
     * @desc 异常类型判断
     */
    private ZuulException zuulException(Throwable e) {
        if (e.getCause() instanceof ZuulRuntimeException) {
            return (ZuulException) e.getCause().getCause();
        }
        if (e.getCause() instanceof ZuulException) {
            return (ZuulException) e.getCause();
        }
        if (e instanceof ZuulException) {
            return (ZuulException) e;
        }
        return new ZuulException(e, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, null);
    }
}
