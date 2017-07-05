package com.personal.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.personal.dao.CustomerDao;
import com.personal.model.Customer;

public class CustomerDaoImpl extends JdbcDaoSupport implements CustomerDao{

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
	public List<Customer> findAllCustomers(){
		String sql = "SELECT * FROM CUSTOMER";
		List<Customer> list = getJdbcTemplate().query(sql, new RowMapper<Customer>() {

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
	//	private DataSource dataSource;
//	
//	public void setDataSource(DataSource dataSource){
//		this.dataSource = dataSource;
//	}
//	
//	@Override
//	public void insert(Customer customer) {
//		String sql = "INSERT INTO CUSTOMER " +
//				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
//		Connection connection = null;
//		try {
//			connection = dataSource.getConnection();
//			PreparedStatement ps = connection.prepareStatement(sql);
//			ps.setInt(1, customer.getCustId());
//			ps.setString(2, customer.getName());
//			ps.setInt(3, customer.getAge());
//			ps.executeUpdate();
//			ps.close();
//			
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//			
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {}
//			}
//		}
//		
//	}
//
//	@Override
//	public Customer findByCustomerId(int custId) {
//		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
//		
//		Connection conn = null;
//		
//		try {
//			conn = dataSource.getConnection();
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, custId);
//			Customer customer = null;
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				customer = new Customer(
//					rs.getInt("CUST_ID"),
//					rs.getString("NAME"), 
//					rs.getInt("Age")
//				);
//			}
//			rs.close();
//			ps.close();
//			return customer;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			if (conn != null) {
//				try {
//				conn.close();
//				} catch (SQLException e) {}
//			}
//		}
//	}	
}
