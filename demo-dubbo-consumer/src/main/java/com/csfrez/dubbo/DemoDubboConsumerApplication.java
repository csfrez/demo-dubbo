package com.csfrez.dubbo;

import com.csfrez.dubbo.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class DemoDubboConsumerApplication {

    @DubboReference(version = "${demo.service.version}")
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboConsumerApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				new Thread(() -> {
					try {
						log.info(" Receive result ======> " + demoService.sayHello("csfrez"));
					} catch (Exception e) {
						log.info("InterruptedException", e);
						//Thread.currentThread().interrupt();
					}
				}).start();
			}
        };
    }
}
