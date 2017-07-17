package com.personal.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Source {

	private English english;

	@Autowired
	private China china;

	public Source(){
	}
	public Source(English english){
		this.english = english;
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
