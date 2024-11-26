package com.java.CarRental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CarRental.model.Customer;
import com.java.CarRental.util.ConnectionHelper;

public class CustomerDaoImpl implements CustomerDao{
	Connection connection;
	PreparedStatement pst;

	@Override
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
	    String cmd = "INSERT INTO customer (customerID, firstName, lastName, email, phoneNumber) VALUES\r\n"
	    		+ "(?,?,?,?,?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, customer.getCustomerId());
	    pst.setString(2, customer.getFirstName());
	    pst.setString(3, customer.getLastName());
	    pst.setString(4, customer.getEmail());
	    pst.setString(5, customer.getPhoneNumber());
	    pst.executeUpdate();
	    return "Customer added......";
	}

	@Override
	public List<Customer> showCustomer() throws SQLException, ClassNotFoundException {
		Customer customer = null;
		connection = ConnectionHelper.getConnection();
		List<Customer> customerList = new ArrayList<>();
		String cmd = "SELECT * FROM CUSTOMER";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			customer = new Customer();
			customer.setCustomerId(rs.getInt("CustomerId"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("LastName"));
			customer.setEmail(rs.getString("Email"));
			customer.setPhoneNumber(rs.getString("PhoneNumber"));
			customerList.add(customer);
		}
		return customerList;

	}

	@Override
	public Customer searchCustomer(int customerId) throws ClassNotFoundException, SQLException {
		Customer customer = new Customer();
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM CUSTOMER WHERE CUSTOMERID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			customer.setCustomerId(rs.getInt("customerId"));
			customer.setCustomerId(rs.getInt("CustomerId"));
			customer.setFirstName(rs.getString("FirstName"));
			customer.setLastName(rs.getString("LastName"));
			customer.setEmail(rs.getString("Email"));
			customer.setPhoneNumber(rs.getString("PhoneNumber"));
		}
		return customer;

	}

}
