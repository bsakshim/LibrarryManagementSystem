package com.library.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.library")
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.library.repository")
@PropertySource("classpath:application.properties")
public class AppConfig {

}
