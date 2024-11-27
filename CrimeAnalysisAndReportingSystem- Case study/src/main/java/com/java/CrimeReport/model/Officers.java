package com.java.CrimeReport.model;

public class Officers {
	
	private int officerId;
	private String firstName;
	private String lastName;
	private int badgeNumber;
	private String ranks;
	private String email;
	private String phoneNumber;
	private int agencyId;
	public int getOfficerId() {
		return officerId;
	}
	public void setOfficerId(int officerId) {
		this.officerId = officerId;
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
	public int getBadgeNumber() {
		return badgeNumber;
	}
	public void setBadgeNumber(int badgeNumber) {
		this.badgeNumber = badgeNumber;
	}
	public String getRanks() {
		return ranks;
	}
	public void setRanks(String ranks) {
		this.ranks = ranks;
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
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	
	public Officers() {
		super();
	}
	
	public Officers(int officerId, String firstName, String lastName, int badgeNumber, String ranks, String email,
			String phoneNumber, int agencyId) {
		super();
		this.officerId = officerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.badgeNumber = badgeNumber;
		this.ranks = ranks;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.agencyId = agencyId;
	}
	
	@Override
	public String toString() {
		return "Officers [officerId=" + officerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", badgeNumber=" + badgeNumber + ", ranks=" + ranks + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", agencyId=" + agencyId + "]";
	}

}