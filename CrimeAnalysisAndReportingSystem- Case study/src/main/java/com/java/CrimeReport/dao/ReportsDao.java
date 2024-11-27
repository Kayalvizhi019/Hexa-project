package com.java.CrimeReport.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CrimeReport.model.Reports;

public interface ReportsDao {
	
	List<Reports> showReports() throws ClassNotFoundException, SQLException;
	Reports searchByReportId(int ReportId) throws ClassNotFoundException, SQLException;
	List<Reports> showReportsByIncident(String Incident) throws ClassNotFoundException, SQLException;
	List<Reports> showUnderInvestigationReports() throws ClassNotFoundException, SQLException;
	List<Reports> showClosedReports() throws ClassNotFoundException, SQLException;
}
