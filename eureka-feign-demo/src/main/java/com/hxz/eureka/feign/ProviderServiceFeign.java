package com.hxz.eureka.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-26-21:12
 * @address 成都
 */
@FeignClient("eureka-provider-demo") // 声明需要远程调用的服务
public interface ProviderServiceFeign {
    // 需要远程调用的接口,这个接口映射的请求地址就是服务提供者controller的地址
    @GetMapping("/list")
    Object list();
}
