package com.java.CrimeReport.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CrimeReport.model.Suspects;

public interface SuspectsDao {
	
	List<Suspects> showSuspects() throws SQLException, ClassNotFoundException;
	List<Suspects> searchSuspectByName(String SuspectName) throws ClassNotFoundException, SQLException;
	String addSuspects(Suspects suspect) throws ClassNotFoundException, SQLException;
	List<Suspects> showSuspectsByIncident(String IncidentType) throws ClassNotFoundException, SQLException;
}
