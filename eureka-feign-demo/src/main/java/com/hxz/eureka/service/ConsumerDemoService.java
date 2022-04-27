package com.hxz.eureka.service;

import com.hxz.dubbo.entity.DemoEntity;
import com.hxz.dubbo.service.IConsumerDemoService;
import com.hxz.eureka.feign.ProviderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 華小灼
 * @version V1.0
 * @desc
 * @copyright &copy; DYH
 * @date 2022-04-26-21:09
 * @address 成都
 */
@Service
public class ConsumerDemoService implements IConsumerDemoService {
    @Autowired
    private ProviderServiceFeign providerServiceFeign;

    @Override
    public List<DemoEntity> list() {
        return (List<DemoEntity>) providerServiceFeign.list();
    }
}
