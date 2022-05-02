package com.hxz.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 网关熔断处理
 * @copyright &copy; DYH
 * @date 2022-05-02-17:33
 * @address 成都
 */
@Component
public class ProviderFallBack implements FallbackProvider {
    /**
     * 需要处理的服务，返回需要处理的服务名称
     * 1. 为指定的服务定义特性化FallBack逻辑
     * 2. 提供一个处理所有服务的通用FallBack逻辑
     */
    @Override
    public String getRoute() {
        return "eureka-feign-demo";
    }

    /**
     * @param route 容错服务名称
     * @param cause 服务异常信息
     * @desc 容错处理逻辑
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 返回状态码
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            /**
             * 返回状态码
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            /**
             * 返回状态码
             */
            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            /**
             * 回收资源
             */
            @Override
            public void close() {

            }

            /**
             * 设置响应体
             * Zuul会将本方法返回的输入流数据读取并通过HttpServletResponse的输出流输出到客户端
             */
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("服务不可用".getBytes());
            }

            /**
             * 设置响应头信息
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
                return headers;
            }
        };
    }
}
