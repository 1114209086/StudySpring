package com.personal.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;
import com.personal.model.CustomerRowMapper;

@SuppressWarnings("deprecation")
public class CustomerDaoImplUseSimpleJdbcTemplate extends SimpleJdbcDaoSupport
		implements CustomerDao {

	@Override
	public void insert(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

		Customer customer = getSimpleJdbcTemplate().queryForObject(sql,
				new CustomerRowMapper(), custId);
		return customer;
	}

	public Customer findByCustomerId2(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

		Customer customer = getSimpleJdbcTemplate().queryForObject(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Customer.class),
				custId);
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM CUSTOMER";
		List<Customer> customersList = getSimpleJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Customer.class));
		return customersList;
	}

	@Override
	public void insertBatch(List<Customer> list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBatchSQL(String sql) {
		// TODO Auto-generated method stub

	}

}
