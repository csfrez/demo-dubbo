package com.csfrez.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoDubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDubboProviderApplication.class, args);
	}

}
