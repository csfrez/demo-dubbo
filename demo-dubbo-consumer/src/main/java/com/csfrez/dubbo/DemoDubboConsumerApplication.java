package com.csfrez.dubbo;

import com.csfrez.dubbo.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@Slf4j
public class DemoDubboConsumerApplication {

    @DubboReference(version = "${demo.service.version}")
    private DemoService demoService;

    ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboConsumerApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            //for (int i = 0; i < 10; i++) {
            int index = 0;
            while(true){
                if(index%2 == 0){
                    Thread.sleep(10000);
                }
                final int i = index;
                executor.submit(() -> {
                    try {
                        log.info(" Receive result ======> " + demoService.sayHello("csfrez"+i));
                    } catch (Exception e) {
                        log.info("Exception", e);
                    }
                });
                index++;
            }
        };
    }
}
