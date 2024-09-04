package com.csfrez.dubbo;

import com.csfrez.dubbo.api.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class DemoDubboConsumerApplication {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@DubboReference(version = "${demo.service.version}")
	private DemoService demoService;

	public static void main(String[] args) {
		SpringApplication.run(DemoDubboConsumerApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner() {
		return args -> {
			new Thread(()-> {
				while (true) {
					try {
						Thread.sleep(5000);
						System.out.println(new Date() + " Receive result ======> " + demoService.sayHello("csfrez"));
					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupt();
					}
				}
			}).start();
		};
	}
}
