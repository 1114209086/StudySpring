package com.personal.spring;

public class Say {
	
	Local local;
	
	public void println(){
		local.print();
	}
	
	public void setLocal(Local local){
		this.local = local;
	}
}
