package com.personal.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;

@SuppressWarnings("deprecation")
public class CustomerDaoImplParamterBind extends SimpleJdbcDaoSupport implements
		CustomerDao {

	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (CUST_ID,NAME,AGE) VALUES (:custId, :name, :age)";
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
	public void insertBatch(List<Customer> customers) {
		String sql = "INSERT INTO CUSTOMER (CUST_ID,NAME,AGE) VLAUES (:custId, :name, :age)";
		List<SqlParameterSource> parameter = new ArrayList<SqlParameterSource>();
		for (Customer customer : customers) {
			parameter.add(new BeanPropertySqlParameterSource(customer));
		}
		getSimpleJdbcTemplate().batchUpdate(sql, parameter.toArray(new SqlParameterSource[0]));

	}
	
	public void insertBatch2(List<Customer> customers) {
		   SqlParameterSource[] params = 
					SqlParameterSourceUtils.createBatch(customers.toArray());
					
				   getSimpleJdbcTemplate().batchUpdate(
					"INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (:custId, :name, :age)",
					params);

	}

	@Override
	public void insertBatchSQL(String sql) {
		// TODO Auto-generated method stub

	}

}
