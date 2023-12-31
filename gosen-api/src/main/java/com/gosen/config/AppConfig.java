package com.gosen.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@PropertySource(value = "classpath:application-${spring.profiles.active}.properties", encoding="UTF-8")
@ConfigurationProperties(prefix = "com.gosen.target")
public class AppConfig {
	private String host;
}
