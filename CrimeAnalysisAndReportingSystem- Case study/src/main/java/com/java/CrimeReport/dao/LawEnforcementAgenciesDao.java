package com.java.CrimeReport.dao;

import java.sql.SQLException;

import com.java.CrimeReport.model.LawEnforcementAgencies;

public interface LawEnforcementAgenciesDao {

	String addLawEnforcement(LawEnforcementAgencies lea) throws ClassNotFoundException, SQLException;
}
