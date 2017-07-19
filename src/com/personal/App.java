package com.personal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;
import com.personal.spring.China;
import com.personal.spring.Say;
import com.personal.spring.Source;
import com.personal.springconfig.BeanContext;

public class App {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//		Say say = (Say) context.getBean("sayBean");
//		say.println();

//		CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAO");
//		 Customer customer = new Customer(3, "yiibai",29);
//		 customerDAO.insert(customer);

//		Customer customer1 = customerDAO.findByCustomerId(1);
//		System.out.println(customer1);
//		System.out.println(customerDAO.findAllCustomers());
//
//
//		String sql = "UPDATE CUSTOMER SET NAME ='BATCHUPDATE'";
//		customerDAO.insertBatchSQL(sql);

//		CustomerDao customerDAO = (CustomerDao) context.getBean("source");
//		Customer customer2 = new Customer(14, "yiibai1", 21);
//		Customer customer3 = new Customer(11, "yiibai2", 22);
//		Customer customer4 = new Customer(12, "yiibai3", 23);
//
//		List<Customer> customers = new ArrayList<Customer>();
//		customers.add(customer2);
//		customers.add(customer3);
//		customers.add(customer4);

//		customerDAO.insert(customer2);
//		String sql = "UPDATE CUSTOMER SET NAME ='BILL'";
//		customerDAO.insertBatchSQL(sql);
//		System.out.println(customerDAO.findByCustomerId(2));
//		System.out.println(customerDAO.findAllCustomers());
//		Source source = (Source) context.getBean("source");
//		source.print();
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanContext.class);
		China china = (China) context.getBean("china");
		china.print();
	}

}
