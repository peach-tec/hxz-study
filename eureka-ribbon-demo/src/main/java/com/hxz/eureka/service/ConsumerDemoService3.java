package com.hxz.eureka.service;

import com.hxz.dubbo.entity.DemoEntity;
import com.hxz.dubbo.service.IConsumerDemoService;
import com.hxz.eureka.config.LoadBalancerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
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

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<DemoEntity> list() {
        // eureka-provider-demo 为服务提供者的服务名
        List<DemoEntity> forObject = restTemplate.getForObject("http://eureka-provider-demo/list", List.class);
        return forObject;
    }
}
