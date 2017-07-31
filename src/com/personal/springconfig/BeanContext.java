package com.personal.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.personal.spring.China;

@Configuration
@Import({BeanContext2.class})
public class BeanContext {

	@Bean(name="china")
	public China en(){
		China scB = new China();
		scB.setName("阳");
		return scB;
	}
}
