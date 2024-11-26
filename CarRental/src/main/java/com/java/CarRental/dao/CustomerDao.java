package com.java.CarRental.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CarRental.model.Customer;

public interface CustomerDao {
	
	String addCustomer(Customer customer) throws ClassNotFoundException, SQLException;
	List<Customer> showCustomer() throws SQLException, ClassNotFoundException;
	Customer searchCustomer(int customerId) throws ClassNotFoundException, SQLException;

}
