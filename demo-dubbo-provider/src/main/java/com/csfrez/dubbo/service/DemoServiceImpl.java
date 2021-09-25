package com.csfrez.dubbo.service;

import com.csfrez.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name ;
    }
}
