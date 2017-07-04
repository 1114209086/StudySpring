package com.personal.spring;

/**
 * Spring Bean
 * @author Wei Shi Xiong
 *
 */
public class HelloWorld {

	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void print(){
		System.out.println("Hello! " + name);
	}
}
