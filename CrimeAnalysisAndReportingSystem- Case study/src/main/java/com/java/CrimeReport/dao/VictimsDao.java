package com.java.CrimeReport.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.CrimeReport.model.Victims;

public interface VictimsDao {
	
	List<Victims> showVictims() throws ClassNotFoundException, SQLException;
	Victims searchByVictimId(int victimId) throws ClassNotFoundException, SQLException;
	List<Victims> searchByVictimName(String victimName) throws SQLException, ClassNotFoundException;
	String addVictim(Victims victim) throws SQLException, ClassNotFoundException;
	List<Victims> showVictimsByIncident(String IncidentType) throws ClassNotFoundException, SQLException;
}
