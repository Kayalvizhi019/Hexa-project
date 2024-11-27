package com.java.CrimeReport.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CrimeReport.model.Gender;
import com.java.CrimeReport.model.Victims;
import com.java.CrimeReport.util.ConnectionHelper;


public class VictimsDaoImpl implements VictimsDao{
	
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public List<Victims> showVictims() throws ClassNotFoundException, SQLException {
		Victims victims = null;
		connection = ConnectionHelper.getConnection();
		List<Victims> victimList = new ArrayList<>();
		String cmd = "SELECT * FROM VICTIMS";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			victims = new Victims();
			victims.setVictimId(rs.getInt("victimId"));
			victims.setFirstName(rs.getString("firstName"));
			victims.setLastName(rs.getString("lastName"));
			victims.setDateOfBirth(rs.getDate("dateOfBirth"));
			victims.setGender(Gender.valueOf(rs.getString("gender")));
			victims.setEmail(rs.getString("email"));
			victims.setPhoneNumber(rs.getString("phoneNumber"));
			victimList.add(victims);
		}
		return victimList;
	}
	
	@Override
	public Victims searchByVictimId(int victimId) throws ClassNotFoundException, SQLException {
		Victims victims = new Victims();
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM VICTIMS WHERE VICTIMID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, victimId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			victims.setVictimId(rs.getInt("victimId"));
			victims.setFirstName(rs.getString("firstName"));
			victims.setLastName(rs.getString("lastName"));
			victims.setDateOfBirth(rs.getDate("dateOfBirth"));
			victims.setGender(Gender.valueOf(rs.getString("gender")));
			victims.setEmail(rs.getString("email"));
			victims.setPhoneNumber(rs.getString("phoneNumber"));
		}
		return victims;
	}

	@Override
	public List<Victims> searchByVictimName(String victimName) throws SQLException, ClassNotFoundException {
		Victims victims = null;
		List<Victims> victimList = new ArrayList<>();
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM VICTIMS WHERE FirstName = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, victimName);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			victims = new Victims();
			victims.setVictimId(rs.getInt("victimId"));
			victims.setFirstName(rs.getString("firstName"));
			victims.setLastName(rs.getString("lastName"));
			victims.setDateOfBirth(rs.getDate("dateOfBirth"));
			victims.setGender(Gender.valueOf(rs.getString("gender")));
			victims.setEmail(rs.getString("email"));
			victims.setPhoneNumber(rs.getString("phoneNumber"));
			victimList.add(victims);
		}
		return victimList;
	}

	@Override
	public String addVictim(Victims victim) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO Victims (VictimId, FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber)\r\n"
				+ "VALUES\r\n"
				+ "    (?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, victim.getVictimId());
		pst.setString(2, victim.getFirstName());
		pst.setString(3, victim.getLastName());
		pst.setDate(4, victim.getDateOfBirth());
		pst.setString(5, victim.getGender().toString());
		pst.setString(6, victim.getEmail());
		pst.setString(7, victim.getPhoneNumber());
		pst.executeUpdate();
		return "Victims added......";
	}

	@Override
	public List<Victims> showVictimsByIncident(String IncidentType) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		List<Victims> victimList = new ArrayList<>();
		Victims victim = null;
		String cmd = "SELECT * FROM VICTIMS WHERE VICTIMID IN "
				+ "(SELECT VICTIMID FROM INCIDENTS WHERE incidentType = ?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, IncidentType);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			victim= new Victims();
			victim.setVictimId(rs.getInt("VictimId"));
			victim.setFirstName(rs.getString("FirstName"));
			victim.setLastName(rs.getString("LastName"));
			victim.setDateOfBirth(rs.getDate("DateOfBirth"));
			victim.setGender(Gender.valueOf(rs.getString("Gender")));
			victim.setEmail(rs.getString("Email"));
			victim.setPhoneNumber(rs.getString("PhoneNumber"));
			victimList.add(victim);
		}
		return victimList;
	}

}
