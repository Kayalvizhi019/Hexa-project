package com.java.CrimeReport.model;

public class LawEnforcementAgencies {
	
	private int agencyId;
	private String agencyName;
	private String jurisdiction;
	private String email;
	private String phoneNumber;
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
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
	public LawEnforcementAgencies(int agencyId, String agencyName, String jurisdiction, String email,
			String phoneNumber) {
		super();
		this.agencyId = agencyId;
		this.agencyName = agencyName;
		this.jurisdiction = jurisdiction;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public LawEnforcementAgencies() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LawEnforcementAgencies [agencyId=" + agencyId + ", agencyName=" + agencyName + ", jurisdiction="
				+ jurisdiction + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
