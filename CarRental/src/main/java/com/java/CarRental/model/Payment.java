package com.java.CarRental.model;

import java.sql.Date;

public class Payment {
	
	private int paymentId;
	private int leaseId;
	private Date paymentDate;
	private Double amount;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getLeaseId() {
		return leaseId;
	}
	public void setLeaseId(int leaseId) {
		this.leaseId = leaseId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentId, int leaseId, Date paymentDate, Double amount) {
		super();
		this.paymentId = paymentId;
		this.leaseId = leaseId;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", leaseId=" + leaseId + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}
	
	

}

