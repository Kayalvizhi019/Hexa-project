package com.java.CrimeReport.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CrimeReport.model.Gender;
import com.java.CrimeReport.model.Suspects;
import com.java.CrimeReport.util.ConnectionHelper;


public class SuspectsDaoImpl implements SuspectsDao {
	
	Connection connection;
	PreparedStatement pst;
	

	@Override
	public List<Suspects> showSuspects() throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		List<Suspects> suspectList = new ArrayList<>();
		Suspects suspect = null;
		String cmd = "SELECT * FROM SUSPECTS";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			suspect= new Suspects();
			suspect.setSuspectId(rs.getInt("SuspectId"));
			suspect.setFirstName(rs.getString("FirstName"));
			suspect.setLastName(rs.getString("LastName"));
			suspect.setDateOfBirth(rs.getDate("DateOfBirth"));
			suspect.setEmail(rs.getString("Email"));
			suspect.setPhoneNumber(rs.getString("PhoneNumber"));
			suspectList.add(suspect);
		}
		return suspectList;			
	}


	@Override
	public List<Suspects> searchSuspectByName(String SuspectName) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		List<Suspects> suspectList = new ArrayList<>();
		Suspects suspect = null;
		String cmd = "SELECT * FROM SUSPECTS WHERE FirstName = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, SuspectName);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			suspect = new Suspects();
			suspect.setSuspectId(rs.getInt("SuspectId"));
			suspect.setFirstName(rs.getString("FirstName"));
			suspect.setLastName(rs.getString("LastName"));
			suspect.setDateOfBirth(rs.getDate("DateOfBirth"));
			suspect.setEmail(rs.getString("Email"));
			suspect.setPhoneNumber(rs.getString("PhoneNumber"));
			suspectList.add(suspect);
		}
		return suspectList;
	}
	

	@Override
	public String addSuspects(Suspects suspect) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO Suspects (SuspectId, FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber)\r\n"
				+ "VALUES\r\n"
				+ "    (?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, suspect.getSuspectId());
		pst.setString(2, suspect.getFirstName());
		pst.setString(3, suspect.getLastName());
		pst.setDate(4, suspect.getDateOfBirth());
		pst.setString(5, suspect.getGender().toString());
		pst.setString(6, suspect.getEmail());
		pst.setString(7, suspect.getPhoneNumber());
		pst.executeUpdate();
		return "Suspect Added......";
	}


	@Override
	public List<Suspects> showSuspectsByIncident(String IncidentType) throws ClassNotFoundException, SQLException {
		
		connection = ConnectionHelper.getConnection();
		List<Suspects> suspectList = new ArrayList<>();
		Suspects suspect = null;
		String cmd = "SELECT * FROM SUSPECTS WHERE SUSPECTID IN "
				+ "(SELECT SUSPECTID FROM INCIDENTS WHERE incidentType = ?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, IncidentType);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			suspect= new Suspects();
			suspect.setSuspectId(rs.getInt("SuspectId"));
			suspect.setFirstName(rs.getString("FirstName"));
			suspect.setLastName(rs.getString("LastName"));
			suspect.setGender(Gender.valueOf(rs.getString("Gender")));;
			suspect.setDateOfBirth(rs.getDate("DateOfBirth"));
			suspect.setEmail(rs.getString("Email"));
			suspect.setPhoneNumber(rs.getString("PhoneNumber"));
			suspectList.add(suspect);
		}
		return suspectList;	
	}

}
