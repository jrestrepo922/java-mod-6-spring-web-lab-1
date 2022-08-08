package com.example.javamod6springweblab1;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaMod6SpringWebLab1Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaMod6SpringWebLab1Application.class, args);
	}

	// beans can be added to any file as long as spring will scan that file
	// @SpringBootApplication annotaion will cause Spring to scan this class for bean and no @configuration annotation
	// is required.
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

}
