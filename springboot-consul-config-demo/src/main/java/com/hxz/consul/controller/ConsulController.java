package com.hxz.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022/4/3-16:35
 * @address 成都
 */
@RestController
@RequestMapping("/consul")
@RefreshScope // 实时刷新
public class ConsulController {
    @Value("${name}")
    private String name;

    @GetMapping("/demo")
    public String consulDemo() {
        return name;
    }
}
