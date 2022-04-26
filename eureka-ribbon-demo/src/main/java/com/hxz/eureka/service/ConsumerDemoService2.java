//package com.hxz.eureka.service;
//
//import com.hxz.dubbo.entity.DemoEntity;
//import com.hxz.dubbo.service.IConsumerDemoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//
///**
// * @author 華小灼
// * @version V1.0
// * @desc
// * @copyright &copy; DYH
// * @date 2022-04-24-21:33
// * @address 成都
// */
//@Service("consumerDemoService2")
//public class ConsumerDemoService2 implements IConsumerDemoService {
//    // Ribbon负载均衡器
//    @Autowired
//    private LoadBalancerClient client;
//
//    @Override
//    public List<DemoEntity> list() {
//        StringBuffer sb = new StringBuffer();
//        // 根据服务名称获取服务实例
//        ServiceInstance instance = client.choose("eureka-provider-demo");
//        if (ObjectUtils.isEmpty(instance)) return null;
//        // 根据服务实例信息拼接请求地址
//        sb.append("http://")
//                .append(instance.getHost())
//                .append(":")
//                .append(instance.getPort())
//                .append("/list");
//
//        // 打印测试
//        System.out.println(sb.toString());
//
//        // 发起http请求
//        ResponseEntity<List<DemoEntity>> response = new RestTemplate().exchange(sb.toString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<DemoEntity>>() {
//        });
//        return response.getBody();
//    }
//}
