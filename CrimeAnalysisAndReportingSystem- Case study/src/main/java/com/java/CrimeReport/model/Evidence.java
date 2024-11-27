package com.java.CrimeReport.model;

public class Evidence {
	
	private int evidenceId;
	private String description;
	private String city;
	private int incidentId;
	
	public int getEvidenceId() {
		return evidenceId;
	}
	public void setEvidenceId(int evidenceId) {
		this.evidenceId = evidenceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(int incidentID) {
		this.incidentId = incidentID;
	}
	
	public Evidence() {
		super();
	}
	
	public Evidence(int evidenceId, String description, String city, int incidentId) {
		super();
		this.evidenceId = evidenceId;
		this.description = description;
		this.city = city;
		this.incidentId = incidentId;
	}
	
	@Override
	public String toString() {
		return "EvidenceModel [evidenceId=" + evidenceId + ", description=" + description + ", city=" + city
				+ ", incidentID=" + incidentId + "]";
	}

}

