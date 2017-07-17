package com.personal.spring;

public class Source {

	private English english;

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
		english.print();
	}
	
}
