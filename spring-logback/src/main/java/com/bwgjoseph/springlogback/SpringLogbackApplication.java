package com.bwgjoseph.springlogback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLogbackApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringLogbackApplication.class, args);
	}

	@Bean
	ApplicationRunner init() {
		return arg -> {
			Logger rootLogger = LoggerFactory.getLogger(SpringLogbackApplication.class);
			rootLogger.trace("trace");
			rootLogger.debug("debug");
			rootLogger.info("info");
			rootLogger.warn("warn");
			rootLogger.error("error");
		};
	}
}