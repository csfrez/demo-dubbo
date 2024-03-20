package com.csfrez.dubbo.service;

import com.csfrez.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Date;

@DubboService(version = "${demo.service.version}")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        System.out.println(new Date() + " Receive name ======> " + name);
        return "Hello, " + name ;
    }
}
