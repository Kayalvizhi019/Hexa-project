package com.java.CrimeReport.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.CrimeReport.model.LawEnforcementAgencies;
import com.java.CrimeReport.util.ConnectionHelper;


public class LawEnforcementAgenciesDaoImpl implements LawEnforcementAgenciesDao {
	
	Connection connection;
	PreparedStatement pst;

	@Override
	public String addLawEnforcement(LawEnforcementAgencies lea) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "INSERT INTO LawEnforcementAgencies (AgencyId, AgencyName, Jurisdiction, Email, PhoneNumber) "
				+ "VALUES (?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, lea.getAgencyId());
		pst.setString(2, lea.getAgencyName());
		pst.setString(3, lea.getJurisdiction());
		pst.setString(4, lea.getEmail());
		pst.setString(5, lea.getPhoneNumber());
		pst.executeUpdate();
		return "Law enforcemnet agency added....";
	}

}
