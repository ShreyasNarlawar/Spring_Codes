package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
	@PropertySource("data.properties")
	public class ConfigurationBean {
		
	@Bean
	public PropertySourcesPlaceholderConfigurer getPlaceholder() {
		System.out.println("In Property Sources Placeholder Configurer");
		PropertySourcesPlaceholderConfigurer placeholder =new PropertySourcesPlaceholderConfigurer();
		return placeholder;
	}
}
