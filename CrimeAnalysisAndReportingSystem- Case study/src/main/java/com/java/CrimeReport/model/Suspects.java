package com.java.CrimeReport.model;

import java.sql.Date;

public class Suspects {
	
	private int suspectId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Gender gender;
	private String phoneNumber;
	private String email;
	
	public int getSuspectId() {
		return suspectId;
	}
	public void setSuspectId(int suspectId) {
		this.suspectId = suspectId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Suspects() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Suspects(int suspectId, String firstName, String lastName, Date dateOfBirth, Gender gender, String phoneNumber,
			String email) {
		super();
		this.suspectId = suspectId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Suspects [suspectId=" + suspectId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	

}
