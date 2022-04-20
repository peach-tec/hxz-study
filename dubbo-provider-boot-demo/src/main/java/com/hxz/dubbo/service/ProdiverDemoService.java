package com.hxz.dubbo.service;

import com.hxz.dubbo.entity.DemoEntity;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-19-22:19
 * @address 成都
 */
@Service
@DubboService(group = "${spring.application.name}",version = "1.0.0")  // 暴露服务
public class ProdiverDemoService implements IProviderDemoService {
    @Override
    public List<DemoEntity> list() {
        return Arrays.asList(new DemoEntity(UUID.randomUUID().toString().replace("-", ""), "张三", new Random().nextInt(100)),
                new DemoEntity(UUID.randomUUID().toString().replace("-", ""), "李四", new Random().nextInt(100)),
                new DemoEntity(UUID.randomUUID().toString().replace("-", ""), "王五", new Random().nextInt(100)));
    }
}
