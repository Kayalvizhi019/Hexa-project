package com.java.CrimeReport.model;

import java.sql.Date;

public class Reports {
	private int reportId;
	private int incidentId;
	private int reportingOfficer ;
	private Date reportDate; 
	private String reportDetails;
	private Status status;
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getIncidentId() {
		return incidentId;
	}
	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}
	public int getReportingOfficer() {
		return reportingOfficer;
	}
	public void setReportingOfficer(int reportingOfficer) {
		this.reportingOfficer = reportingOfficer;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportDetails() {
		return reportDetails;
	}
	public void setReportDetails(String reportDetails) {
		this.reportDetails = reportDetails;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Reports() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reports(int reportId, int incidentId, int reportingOfficer, Date reportDate, String reportDetails,
			Status status) {
		super();
		this.reportId = reportId;
		this.incidentId = incidentId;
		this.reportingOfficer = reportingOfficer;
		this.reportDate = reportDate;
		this.reportDetails = reportDetails;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reports [reportId=" + reportId + ", incidentId=" + incidentId + ", reportingOfficer=" + reportingOfficer
				+ ", reportDate=" + reportDate + ", reportDetails=" + reportDetails + ", status=" + status + "]";
	}
	
	
	
}
	
	
