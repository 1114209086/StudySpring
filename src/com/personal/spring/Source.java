package com.personal.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Source {

	private English english;

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

	/**
	 * @return the china
	 */
	public China getChina() {
		return china;
	}
	/**
	 * @param china the china to set
	 */
	@Autowired
	public void setChina(China china) {
		this.china = china;
	}
	public void print(){
		china.print();
	}
	
}
