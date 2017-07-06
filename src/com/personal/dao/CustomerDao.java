package com.personal.dao;

import java.util.List;

import com.personal.model.Customer;

public interface CustomerDao {

	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public List<Customer> findAllCustomers();
	public void insertBatch(List<Customer> list);
	public void insertBatchSQL(String sql);
}
