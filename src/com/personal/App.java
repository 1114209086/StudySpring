package com.personal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;
import com.personal.spring.Say;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Say say = (Say)context.getBean("sayBean");
		say.println();
		
		CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAO");
        Customer customer = new Customer(2, "yiibai",29);
        customerDAO.insert(customer);
    	
        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);
	}
	
}
