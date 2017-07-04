package com.personal.dao;

import com.personal.model.Customer;

public interface CustomerDao {

	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
