package com.hxz.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-19-23:08
 * @address 成都
 */
public class ProviderMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.in.read();
    }
}
