package com.java.CarRental;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.CarRental.model.Payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

import org.junit.Test;

public class PaymentTest {
	
	
	@Test
	public void testgettersandsetters()
	{
		Payment payment = new Payment();
		payment.setPaymentId(1);
		payment.setLeaseId(1);
		payment.setAmount(1000.00);
		String s1 = "2024-10-10";
		Date d1 = Date.valueOf(s1);
		payment.setPaymentDate(d1);
		assertEquals(1, payment.getPaymentId());
		assertEquals(1, payment.getLeaseId());
		assertEquals(1000.00, payment.getAmount(), 0.0001);
		assertEquals(d1, payment.getPaymentDate());
		
	}
	
	@Test
	public void testconstructor()
	{
		Payment payment = new Payment();
		assertNotNull(payment);
		String s1 = "2024-10-10";
		Date d1 = Date.valueOf(s1);
		Payment payment1 = new Payment(1, 1, d1, 1000.00);
		assertEquals(1, payment1.getPaymentId());
		assertEquals(1, payment1.getLeaseId());
		assertEquals(d1, payment1.getPaymentDate());
		assertEquals(1000.00, payment1.getAmount(), 0.0001);
	}

	
	@Test
	public void testtoString()
	{
		String s1 = "2024-10-10";
		Date d1 = Date.valueOf(s1);
		Payment payment1 = new Payment(1, 1, d1, 1000.00);
		String result = "Payment [paymentId=1, leaseId=1, paymentDate=2024-10-10, amount=1000.0]";
		assertEquals(result, payment1.toString());
	}
	

}
