package com.personal.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;

@SuppressWarnings("deprecation")
public class CustomerDaoImplParamterBind extends SimpleJdbcDaoSupport implements
		CustomerDao {

	@Override
	public void insert(Customer customer) {
		String sql = "insert into customer (cust_id,name,age) values (:custId, :name, :age)";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("custId", customer.getCustId());
		parameters.put("name", customer.getName());
		parameters.put("age", customer.getAge());
		getSimpleJdbcTemplate().update(sql, parameters);

	}

	@Override
	public Customer findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return null;
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
