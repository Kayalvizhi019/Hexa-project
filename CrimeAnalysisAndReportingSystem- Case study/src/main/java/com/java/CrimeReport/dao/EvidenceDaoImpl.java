package com.java.CrimeReport.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CrimeReport.model.Evidence;
import com.java.CrimeReport.util.ConnectionHelper;


public class EvidenceDaoImpl implements EvidenceDao {
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public Evidence searchByEvidenceId(int EvidenceId) throws ClassNotFoundException, SQLException {
		Evidence evidence = new Evidence();
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM Evidence WHERE EVIDENCEID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, EvidenceId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			evidence.setEvidenceId(rs.getInt("EvidenceId"));
			evidence.setDescription(rs.getString("Description"));
			evidence.setCity(rs.getString("City"));
			evidence.setIncidentId(rs.getInt("IncidentId"));
		}
		return evidence;
	}

	@Override
	public List<Evidence> showEvidenceByIncident(int IncidentId) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		List<Evidence> evidenceList = new ArrayList<>();
		Evidence evidence = null;
		String cmd = "SELECT * FROM EVIDENCE WHERE INCIDENTID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, IncidentId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
		    evidence = new Evidence();
		    evidence.setEvidenceId(rs.getInt("EvidenceId"));
			evidence.setDescription(rs.getString("Description"));
			evidence.setCity(rs.getString("City"));
			evidence.setIncidentId(rs.getInt("IncidentId"));
		    evidenceList.add(evidence);
		}
		return evidenceList;

	}

	@Override
	public String addEvidence(Evidence evidence) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
	    String cmd = "INSERT INTO Evidence (EvidenceId, Description, City, IncidentId) VALUES (?,?,?,?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, evidence.getEvidenceId());
	    pst.setString(2, evidence.getDescription());
	    pst.setString(3, evidence.getCity());
	    pst.setInt(4, evidence.getIncidentId());
	    pst.executeUpdate();
	    return "Evidence added......";
	}

}
