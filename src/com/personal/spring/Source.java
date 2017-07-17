package com.personal.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Source {

	private English english;

	private China china;

	public Source(English english){
		this.english = english;
	}

	@Autowired
	public Source(China china){
		this.china = china;
	}
	/**
	 * @return the english
	 */
	public English getEnglish() {
		return english;
	}

	/**
	 * @param english the english to set
	 */
	public void setEnglish(English english) {
		this.english = english;
	}
	
	public void print(){
		china.print();
	}
	
}
