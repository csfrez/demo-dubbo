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
		return args -> logger.info(demoService.sayHello("csfrez"));
	}

}
