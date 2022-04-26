package com.hxz.eureka.controller;

import com.hxz.dubbo.service.IConsumerDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
//    @Autowired
//    @Qualifier(value = "consumerDemoService1")
//    private IConsumerDemoService consumerService1;
//
//    @Autowired
//    @Qualifier(value = "consumerDemoService2")
//    private IConsumerDemoService consumerService2;

    @Autowired
    @Qualifier(value = "consumerDemoService3")
    private IConsumerDemoService consumerService3;


//    @GetMapping("/list/1")
//    public Object list1() {
//        return consumerService1.list();
//    }
//
//    @GetMapping("/list/2")
//    public Object list2() {
//        return consumerService2.list();
//    }

    @GetMapping("/list/3")
    public Object list3() {
        return consumerService3.list();
    }
}
