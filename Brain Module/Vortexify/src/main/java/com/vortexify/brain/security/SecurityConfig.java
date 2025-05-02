package com.vortexify.brain.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
	
	
	   @Bean
	    public FilterRegistrationBean<FilterComponent> apiKeyFilter(FilterComponent filter) {
	        FilterRegistrationBean<FilterComponent> registrationBean = new FilterRegistrationBean<>();
	        registrationBean.setFilter(filter);
	        registrationBean.addUrlPatterns("/api/*"); // restrict to APIs only
	        registrationBean.setOrder(1);
	        return registrationBean;
	    }

}
