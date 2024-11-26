package com.java.CarRental.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CarRental.model.Payment;

public interface PaymentDao {

	List<Payment> showPaymentsByLeaseId(int leaseId) throws ClassNotFoundException, SQLException;
	List<Payment> showPayments() throws ClassNotFoundException, SQLException;
}
