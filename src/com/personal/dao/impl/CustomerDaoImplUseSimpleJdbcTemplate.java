package com.personal.dao.impl;

import java.util.ArrayList;
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
	public void insertBatch(List<Customer> customers) {
		String sql = "INSERT INTO CUSTOMER (CUST_ID,NAME,AGE) VALUE (?,?,?)";

		List<Object[]> parameters = new ArrayList<Object[]>();

		for (Customer customer : customers) {
			parameters.add(new Object[] { customer.getCustId(),
					customer.getName(), customer.getAge() });
		}
		getSimpleJdbcTemplate().batchUpdate(sql, parameters);

	}

	@Override
	public void insertBatchSQL(String sql) {
		getJdbcTemplate().batchUpdate(new String[] { sql });
	}

}
