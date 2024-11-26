package com.java.CarRental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CarRental.model.Payment;
import com.java.CarRental.util.ConnectionHelper;

public class PaymentDaoImpl implements PaymentDao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Payment> showPaymentsByLeaseId(int leaseId) throws ClassNotFoundException, SQLException {
		Payment payment = null;
		connection = ConnectionHelper.getConnection();
		List<Payment> paymentList = new ArrayList<>();
		String cmd = "SELECT * FROM Payment where leaseId = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, leaseId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			payment = new Payment();
			payment.setPaymentId(rs.getInt("paymentId"));
			payment.setLeaseId(rs.getInt("LeaseId"));
			payment.setPaymentDate(rs.getDate("paymentDate"));
			payment.setAmount(rs.getDouble("Amount"));
			paymentList.add(payment);
		}
		return paymentList;
	}

	@Override
	public List<Payment> showPayments() throws ClassNotFoundException, SQLException {
		Payment payment = null;
		connection = ConnectionHelper.getConnection();
		List<Payment> paymentList = new ArrayList<>();
		String cmd = "SELECT * FROM Payment";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			payment = new Payment();
			payment.setPaymentId(rs.getInt("paymentId"));
			payment.setLeaseId(rs.getInt("LeaseId"));
			payment.setPaymentDate(rs.getDate("paymentDate"));
			payment.setAmount(rs.getDouble("Amount"));
			paymentList.add(payment);
		}
		return paymentList;
	}

	
}
