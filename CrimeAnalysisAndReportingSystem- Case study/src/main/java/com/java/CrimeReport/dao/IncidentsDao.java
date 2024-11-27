package com.java.CrimeReport.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CrimeReport.model.Incidents;

public interface IncidentsDao {
	
	String AddIncidents(Incidents incidents) throws ClassNotFoundException, SQLException;
	List<Incidents> ShowIncidentByType(String IncidentType) throws SQLException, ClassNotFoundException;
}
