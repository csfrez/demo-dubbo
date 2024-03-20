package com.csfrez.dubbo;

import com.csfrez.dubbo.api.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

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
			new Thread(()-> {
				for (int i=0; i<10; i++) {
					try {
						Thread.sleep(1000);
						log.info(" Receive result ======> " + demoService.sayHello("csfrez"));
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
				}
			}).start();
		};
	}
}
