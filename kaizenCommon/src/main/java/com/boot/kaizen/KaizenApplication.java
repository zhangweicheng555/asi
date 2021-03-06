package com.boot.kaizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动类
 */
@EnableCaching
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class KaizenApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaizenApplication.class, args);
	}

}
