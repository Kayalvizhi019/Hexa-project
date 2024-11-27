package com.java.CrimeReport.model;

import java.sql.Date;

public class Victims {
	
	private int victimId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Gender gender;
	private String email;
	private String phoneNumber;
	
	
	public int getVictimId() {
		return victimId;
	}
	public void setVictimId(int victimId) {
		this.victimId = victimId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Victims() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Victims(int victimId, String firstName, String lastName, Date dateOfBirth, Gender gender, String email,
			String phoneNumber) {
		super();
		this.victimId = victimId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Victims [victimId=" + victimId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	

	
	
	
	
}