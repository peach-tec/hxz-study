package com.hxz.dubbo.service;

import com.hxz.dubbo.entity.DemoEntity;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-19-22:30
 * @address 成都
 */
@Service
public class ConsumerDemoService implements IConsumerDemoService {
    @DubboReference(group = "dubbo-provider-boot-demo", version = "1.0.0") // 远程调用服务
    private IProviderDemoService providerService;

    @Override
    public List<DemoEntity> list() {
        return providerService.list();
    }
}