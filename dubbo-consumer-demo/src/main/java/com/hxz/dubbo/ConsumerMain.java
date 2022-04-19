package com.hxz.dubbo;

import com.hxz.dubbo.entity.DemoEntity;
import com.hxz.dubbo.service.ConsumerDemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-19-23:08
 * @address 成都
 */
public class ConsumerMain {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        ConsumerDemoService service = context.getBean(ConsumerDemoService.class);
        List<DemoEntity> list = service.list();
        list.forEach(System.out::println);
        System.in.read();
    }
}
