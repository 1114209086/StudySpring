package com.personal.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.personal.spring.English;

@Configuration
public class BeanContext2 {

	@Bean(name="english")
	public English getEnglish(){
		return new English();
	}
}
