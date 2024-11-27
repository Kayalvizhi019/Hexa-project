package com.java.CrimeReport.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CrimeReport.model.Evidence;

public interface EvidenceDao {
	
	Evidence searchByEvidenceId(int EvidenceId) throws ClassNotFoundException, SQLException;
	List<Evidence> showEvidenceByIncident(int IncidentId) throws SQLException, ClassNotFoundException;
	String addEvidence(Evidence evidence) throws ClassNotFoundException, SQLException;
}
