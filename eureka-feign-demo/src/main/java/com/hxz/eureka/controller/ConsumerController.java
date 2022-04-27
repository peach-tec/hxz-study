package com.hxz.eureka.controller;

import com.hxz.dubbo.service.IConsumerDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-20-19:57
 * @address 成都
 */
@RestController
public class ConsumerController {
    @Autowired
    private IConsumerDemoService consumerService1;


    @GetMapping("/list")
    public Object list1() {
        return consumerService1.list();
    }
}
