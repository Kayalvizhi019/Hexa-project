package com.java.CarRental.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CarRental.model.Lease;

public interface LeaseDao {

	String addLease(Lease lease) throws ClassNotFoundException, SQLException;
	List<Lease> showLeaseByStartDate(String date) throws ClassNotFoundException, SQLException;
	
}
