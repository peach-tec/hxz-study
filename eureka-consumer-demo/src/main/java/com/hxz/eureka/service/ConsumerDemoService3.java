package com.hxz.eureka.service;

import com.hxz.dubbo.entity.DemoEntity;
import com.hxz.dubbo.service.IConsumerDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-24-21:34
 * @address 成都
 */
@Service("consumerDemoService3")
public class ConsumerDemoService3 implements IConsumerDemoService {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Override
    public List<DemoEntity> list() {
        // eureka-provider-demo 为服务提供者的服务名
        ResponseEntity<List<DemoEntity>> response = restTemplate.exchange("http://eureka-provider-demo/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<DemoEntity>>() {
        });
        return response.getBody();
    }
}
