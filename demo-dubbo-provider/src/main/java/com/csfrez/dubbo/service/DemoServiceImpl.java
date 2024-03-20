package com.csfrez.dubbo.service;

import com.csfrez.dubbo.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.Date;

@DubboService(version = "${demo.service.version}")
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        log.info(" Receive name ======> " + name);
        return "Hello, " + name ;
    }
}
