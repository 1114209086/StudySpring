package com.personal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;

public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao {

	@Override
	public void insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER "
				+ "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		getJdbcTemplate().update(
				sql,
				new Object[] { customer.getCustId(), customer.getName(),
						customer.getAge() });
	}

	@Override
	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
		return getJdbcTemplate().query(sql, new Object[] { custId },
				new RowMapper<Customer>() {

					public Customer mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						Customer cat = new Customer();
						cat.setCustId(rs.getInt("CUST_ID"));
						cat.setName(rs.getString("NAME"));
						cat.setAge(rs.getInt("AGE"));
						return cat;
					}
				}).get(0);

	}

	@Override
	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM CUSTOMER";
		List<Customer> list = getJdbcTemplate().query(sql,
				new RowMapper<Customer>() {

					public Customer mapRow(ResultSet rs, int index)
							throws SQLException {
						// TODO Auto-generated method stub
						Customer cat = new Customer();
						cat.setCustId(rs.getInt("CUST_ID"));
						cat.setName(rs.getString("NAME"));
						cat.setAge(rs.getInt("AGE"));
						return cat;
					}
				});
		return list;
	}

	@Override
	public void insertBatch(final List<Customer> customerList) {

		String sql = "INSERT INTO CUSTOMER "
				+ "(CUST_ID,NAME,AGE) VALUES (?,?,?)";

		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Customer customer = customerList.get(i);
				ps.setLong(1, customer.getCustId());
				ps.setString(2, customer.getName());
				ps.setInt(3, customer.getAge());

			}

			@Override
			public int getBatchSize() {
				return customerList.size();
			}
		});

	}

	@Override
	public void insertBatchSQL(String sql) {
		getJdbcTemplate().batchUpdate(new String[]{sql});

	}

}
