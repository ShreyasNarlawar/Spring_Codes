package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MyConfiguration {
	
	@Bean
	public ResourceBundleMessageSource getObj() {
		System.out.println("in get object method");
		ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
		rs.setBasename("msg");
		return rs;
	}
}
