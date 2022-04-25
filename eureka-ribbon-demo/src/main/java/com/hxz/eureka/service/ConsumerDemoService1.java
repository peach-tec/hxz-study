package com.hxz.eureka.service;

import com.hxz.dubbo.entity.DemoEntity;
import com.hxz.dubbo.service.IConsumerDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc 原生请求
 * @copyright &copy; DYH
 * @date 2022-04-19-22:30
 * @address 成都
 */
@Service("consumerDemoService1")
public class ConsumerDemoService1 implements IConsumerDemoService {
    @Autowired
    private DiscoveryClient client;

    @Override
    public List<DemoEntity> list() {
        StringBuffer sb = new StringBuffer();
        // 从注册中心获取服务列表
        List<String> services = client.getServices();
        if (CollectionUtils.isEmpty(services)) return null;
        // 根据服务名称获取服务实例
        List<ServiceInstance> instances = client.getInstances("eureka-provider-demo");
        if (CollectionUtils.isEmpty(instances)) return null;
        // 服务实例
        ServiceInstance serviceInstance = instances.get(0);
        // 根据服务实例信息拼接请求地址
        sb.append("http://")
                .append(serviceInstance.getHost())
                .append(":")
                .append(serviceInstance.getPort())
                .append("/list");
        // 发起http请求
        ResponseEntity<List<DemoEntity>> response = new RestTemplate().exchange(sb.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<DemoEntity>>() {
        });
        return response.getBody();
    }
}
