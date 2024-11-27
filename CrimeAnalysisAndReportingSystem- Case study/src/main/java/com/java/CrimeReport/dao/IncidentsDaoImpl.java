package com.java.CrimeReport.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CrimeReport.model.Incidents;
import com.java.CrimeReport.model.Status;
import com.java.CrimeReport.util.ConnectionHelper;

public class IncidentsDaoImpl implements IncidentsDao {

	Connection connection;
	PreparedStatement pst;
	
	
	
	@Override
	public String AddIncidents(Incidents incidents) throws ClassNotFoundException, SQLException, NullPointerException {
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO Incidents (IncidentId, IncidentType, IncidentDate, City, Description, Status, VictimID, SuspectID, OfficerID)\r\n"
				+ "VALUES\r\n"
				+ "    (?,?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, incidents.getIncidentId());
		pst.setString(2, incidents.getIncidentType());
		pst.setDate(3, incidents.getIncidentDate());
		pst.setString(4, incidents.getCity());
		pst.setString(5, incidents.getDescription());
		pst.setString(6, incidents.getStatus().toString());
		pst.setInt(7, incidents.getVictimId());
		pst.setInt(8, incidents.getSuspectId());
		pst.setInt(9, incidents.getOfficerId());
		pst.executeUpdate();
		return "Incident added......";
		
	}



	@Override
	public List<Incidents> ShowIncidentByType(String IncidentType) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		Incidents incidents = null;
		List<Incidents> incidentList = new ArrayList<>();
		String cmd = "SELECT * FROM INCIDENTS WHERE IncidentType = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, IncidentType);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			incidents = new Incidents();
			incidents.setIncidentId(rs.getInt("IncidentId"));
			incidents.setIncidentType(rs.getString("IncidentType"));
			incidents.setIncidentDate(rs.getDate("IncidentDate"));
			incidents.setCity(rs.getString("City"));
			incidents.setDescription(rs.getString("Description"));
			incidents.setStatus(Status.valueOf(rs.getString("Status")));
			incidents.setVictimId(rs.getInt("VictimId"));
			incidents.setSuspectId(rs.getInt("SuspectId"));
			incidents.setOfficerId(rs.getInt("OfficerId"));
			incidentList.add(incidents);
		}
		return incidentList;
	}

	

}
