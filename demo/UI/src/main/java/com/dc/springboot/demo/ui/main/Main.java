package com.dc.springboot.demo.ui.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.dc.springboot.demo.ui.filter.SessionFilter;

@SpringBootApplication
@ComponentScan(basePackages = "com.dc.springboot.demo.ui")
public class Main extends SpringBootServletInitializer {
	
	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		log.info("backend starting");
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	public FilterRegistrationBean sessionFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new SessionFilter());
		registration.addUrlPatterns("/*");
		// registration.addInitParameter("paramName", "paramValue");
		registration.setName("sessionFilter");
		registration.setOrder(1);
		return registration;
	}

}
