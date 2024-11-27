package com.java.CrimeReport.model;

import java.sql.Date;

public class Incidents {
	
	private int incidentId;
	private String incidentType;
	private Date incidentDate;
	private String city;
	private String description;
	private Status status;
	private int victimId;
	private int suspectId;
	private int officerId;
	
	
	
	
	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public String getIncidentType() {
		return incidentType;
	}

	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}

	public Date getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(Date d1) {
		this.incidentDate = d1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getVictimId() {
		return victimId;
	}

	public void setVictimId(int victimId) {
		this.victimId = victimId;
	}

	public int getSuspectId() {
		return suspectId;
	}

	public void setSuspectId(int suspectId) {
		this.suspectId = suspectId;
	}

	public int getOfficerId() {
		return officerId;
	}

	public void setOfficerId(int officerId) {
		this.officerId = officerId;
	}

	public Incidents() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Incidents(int incidentId, String incidentType, Date incidentDate, String city, String description,
			Status status, int victimId, int suspectId, int officerId) {
		super();
		this.incidentId = incidentId;
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.city = city;
		this.description = description;
		this.status = status;
		this.victimId = victimId;
		this.suspectId = suspectId;
		this.officerId = officerId;
	}

	@Override
	public String toString() {
		return "Incidents [incidentId=" + incidentId + ", incidentType=" + incidentType + ", incidentDate="
				+ incidentDate + ", city=" + city + ", description=" + description + ", status=" + status
				+ ", victimId=" + victimId + ", suspectId=" + suspectId + ", officerId=" + officerId + "]";
	}
	
	
	

}

