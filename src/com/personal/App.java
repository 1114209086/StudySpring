package com.personal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;
import com.personal.spring.Say;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		Say say = (Say) context.getBean("sayBean");
//		say.println();

//		CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAO");
//		 Customer customer = new Customer(3, "yiibai",29);
//		 customerDAO.insert(customer);

//		Customer customer1 = customerDAO.findByCustomerId(1);
//		System.out.println(customer1);
//		System.out.println(customerDAO.findAllCustomers());
//
//		Customer customer2 = new Customer(7, "yiibai1", 21);
//		Customer customer3 = new Customer(8, "yiibai2", 22);
//		Customer customer4 = new Customer(9, "yiibai3", 23);
//
//		List<Customer> customers = new ArrayList<Customer>();
//		customers.add(customer2);
//		customers.add(customer3);
//		customers.add(customer4);
//
//		customerDAO.insertBatch(customers);
//
//		String sql = "UPDATE CUSTOMER SET NAME ='BATCHUPDATE'";
//		customerDAO.insertBatchSQL(sql);

		CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAOSimple");

		System.out.println(customerDAO.findByCustomerId(2));
	}

}
