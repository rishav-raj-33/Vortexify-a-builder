package com.vortexify.brain;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class VortexifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(VortexifyApplication.class, args);
	}
	
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	@Bean
	RestTemplate createTemplate() {
		return new RestTemplate();
	}

}
