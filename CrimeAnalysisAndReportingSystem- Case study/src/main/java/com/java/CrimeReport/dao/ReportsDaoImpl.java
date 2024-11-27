package com.java.CrimeReport.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CrimeReport.model.Reports;
import com.java.CrimeReport.model.Status;
import com.java.CrimeReport.util.ConnectionHelper;




public class ReportsDaoImpl implements ReportsDao {
	
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Reports> showReports() throws ClassNotFoundException, SQLException {
		List<Reports> reportList = new ArrayList<>();
		Reports report = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM REPORTS";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			report = new Reports();
			report.setReportId(rs.getInt("ReportId"));
			report.setIncidentId(rs.getInt("IncidentId"));
			report.setReportingOfficer(rs.getInt("ReportingOfficer"));
			report.setReportDate(rs.getDate("ReportDate"));
			report.setReportDetails(rs.getString("ReportDetails"));
			report.setStatus(Status.valueOf(rs.getString("Status")));
			reportList.add(report);
		}
		return reportList;
	}

	@Override
	public Reports searchByReportId(int ReportId) throws ClassNotFoundException, SQLException {
		Reports report = new Reports();
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM REPORTS WHERE REPORTID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, ReportId);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			report.setReportId(rs.getInt("ReportId"));
			report.setIncidentId(rs.getInt("IncidentId"));
			report.setReportingOfficer(rs.getInt("ReportingOfficer"));
			report.setReportDate(rs.getDate("ReportDate"));
			report.setReportDetails(rs.getString("ReportDetails"));
			report.setStatus(Status.valueOf(rs.getString("Status")));
		}
		return report;
	}

	@Override
	public List<Reports> showReportsByIncident(String Incident) throws ClassNotFoundException, SQLException {
		List<Reports> reportList = new ArrayList<>();
		Reports report = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM REPORTS WHERE REPORTID in "
				+ "(SELECT REPORTID FROM INCIDENTS WHERE INCIDENTTYPE = ?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, Incident);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			report = new Reports();
			report.setReportId(rs.getInt("ReportId"));
			report.setIncidentId(rs.getInt("IncidentId"));
			report.setReportingOfficer(rs.getInt("ReportingOfficer"));
			report.setReportDate(rs.getDate("ReportDate"));
			report.setReportDetails(rs.getString("ReportDetails"));
			report.setStatus(Status.valueOf(rs.getString("Status")));
			reportList.add(report);
		}
		return reportList;
	}

	@Override
	public List<Reports> showUnderInvestigationReports() throws ClassNotFoundException, SQLException {
		List<Reports> reportList = new ArrayList<>();
		Reports report = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM REPORTS WHERE STATUS = 'UNDER_INVESTIGATION'";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			report = new Reports();
			report.setReportId(rs.getInt("ReportId"));
			report.setIncidentId(rs.getInt("IncidentId"));
			report.setReportingOfficer(rs.getInt("ReportingOfficer"));
			report.setReportDate(rs.getDate("ReportDate"));
			report.setReportDetails(rs.getString("ReportDetails"));
			report.setStatus(Status.valueOf(rs.getString("Status")));
			reportList.add(report);
		}
		return reportList;
	}

	@Override
	public List<Reports> showClosedReports() throws ClassNotFoundException, SQLException {
		List<Reports> reportList = new ArrayList<>();
		Reports report = null;
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM REPORTS WHERE STATUS = 'CLOSED'";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			report = new Reports();
			report.setReportId(rs.getInt("ReportId"));
			report.setIncidentId(rs.getInt("IncidentId"));
			report.setReportingOfficer(rs.getInt("ReportingOfficer"));
			report.setReportDate(rs.getDate("ReportDate"));
			report.setReportDetails(rs.getString("ReportDetails"));
			report.setStatus(Status.valueOf(rs.getString("Status")));
			reportList.add(report);
		}
		return reportList;
	}

}
