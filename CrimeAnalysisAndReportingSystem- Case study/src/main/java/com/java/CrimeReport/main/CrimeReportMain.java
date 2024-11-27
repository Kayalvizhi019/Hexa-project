package com.java.CrimeReport.main;

import com.java.CrimeReport.dao.IncidentsDaoImpl;
import com.java.CrimeReport.dao.LawEnforcementAgenciesDaoImpl;
import com.java.CrimeReport.dao.SuspectsDao;
import com.java.CrimeReport.dao.SuspectsDaoImpl;
import com.java.CrimeReport.dao.LawEnforcementAgenciesDao;
import com.java.CrimeReport.dao.VictimsDao;
import com.java.CrimeReport.dao.ReportsDao;
import com.java.CrimeReport.dao.EvidenceDao;
import com.java.CrimeReport.dao.EvidenceDaoImpl;
import com.java.CrimeReport.dao.ReportsDaoImpl;
import com.java.CrimeReport.dao.VictimsDaoImpl;
import com.java.CrimeReport.model.Evidence;
import com.java.CrimeReport.model.Gender;
import com.java.CrimeReport.model.Incidents;
import com.java.CrimeReport.model.LawEnforcementAgencies;
import com.java.CrimeReport.model.Reports;
import com.java.CrimeReport.model.Status;
import com.java.CrimeReport.model.Suspects;
import com.java.CrimeReport.model.Victims;

import java.sql.SQLException;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.java.CrimeReport.dao.IncidentsDao;

public class CrimeReportMain {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void showVictims() throws ClassNotFoundException, SQLException {
		VictimsDao dao = new VictimsDaoImpl();
		List<Victims> victimList = dao.showVictims();
		
		for (Victims victims : victimList) {
			System.out.println(victims);
		}
	}
	
	public static void addLawEnforcement() throws ClassNotFoundException, SQLException {
		LawEnforcementAgenciesDao dao = new LawEnforcementAgenciesDaoImpl();
		LawEnforcementAgencies lea = new LawEnforcementAgencies();
		System.out.println("Enter AgencyId : ");
		lea.setAgencyId(sc.nextInt());
		System.out.println("Enter Agency Name : ");
		lea.setAgencyName(sc.next());
		System.out.println("Enter Jurisdiction : ");
		lea.setJurisdiction(sc.next());
		System.out.println("Enter Email : ");
		lea.setEmail(sc.next());
		System.out.println("Enter Phone Number : ");
		lea.setPhoneNumber(sc.next());
		System.out.println(dao.addLawEnforcement(lea));
	}
	public static void addVictim() throws ClassNotFoundException, SQLException, ParseException {
		VictimsDao Dao = new VictimsDaoImpl();
		Victims victims = new Victims();
		System.out.println("Enter VictimtId : ");
		victims.setVictimId(sc.nextInt());
		System.out.println("Enter First Name : ");
		victims.setFirstName(sc.next());
		System.out.println("Enter Last Name : ");
		victims.setLastName(sc.next());
		System.out.println("Enter Date Of Birth (yyyy-MM-dd) : ");
		Date dt1 = null;
		dt1 = Date.valueOf(sc.next());
		victims.setDateOfBirth(dt1);
		System.out.println("Enter Gender : ");
		victims.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Email : ");
		victims.setEmail(sc.next());
		System.out.println("Enter Phone Number : ");
		victims.setPhoneNumber(sc.next());
		System.out.println(Dao.addVictim(victims));
	}
	public static void addIncidents() throws ParseException, ClassNotFoundException, SQLException {
		IncidentsDao incidentDao = new IncidentsDaoImpl();
		Incidents incidents = new Incidents();
		System.out.println("Enter IncidentId : ");
		incidents.setIncidentId(sc.nextInt());
		System.out.println("Enter IncidentType : ");
		incidents.setIncidentType(sc.next());
		System.out.println("Enter IncidentDate (yyyy-MM-dd) : ");
		Date dt1 = null;
		dt1 = Date.valueOf(sc.next());
		incidents.setIncidentDate(dt1);
		System.out.println("Enter City: ");
		incidents.setCity(sc.next());
		System.out.println("Enter Description : ");
		incidents.setDescription(sc.next());
		System.out.println("Enter Status : ");
		incidents.setStatus(Status.valueOf(sc.next()));
		System.out.println("Enter VictimeId : ");
		incidents.setVictimId(sc.nextInt());
		System.out.println("Enter SuspectId : ");
		incidents.setSuspectId(sc.nextInt());
		System.out.println("Enter OfficertId : ");
		incidents.setOfficerId(sc.nextInt());
		System.out.println(incidentDao.AddIncidents(incidents));
		
	}
	public static void showSuspect() throws SQLException, ClassNotFoundException {
		SuspectsDao dao = new SuspectsDaoImpl();
		List<Suspects> suspectList = dao.showSuspects();
		
		for (Suspects suspect : suspectList) {
			System.out.println(suspect);
		}
	}
	public static void showIncidentByType() throws ClassNotFoundException, SQLException {
		IncidentsDao Dao = new IncidentsDaoImpl();
		System.out.println("Enter IncidentType : ");
		List<Incidents> incidentList = Dao.ShowIncidentByType(sc.next());
		for (Incidents incidents: incidentList) {
			System.out.println(incidents);
		}
	}
	
	public static void searchByVictimId() throws ClassNotFoundException, SQLException {
		VictimsDao dao = new VictimsDaoImpl();
		System.out.println("Enter VictimId : ");
		System.out.println(dao.searchByVictimId(sc.nextInt()));
		
	}
	public static void searchByVictimName() throws ClassNotFoundException, SQLException {
		VictimsDao Dao = new VictimsDaoImpl();
		System.out.println("Enter VictimName : ");
		List<Victims> victimList = Dao.searchByVictimName(sc.next());
		for (Victims victim: victimList) {
			System.out.println(victim);
		}
	}
	public static void searchSuspectByName() throws ClassNotFoundException, SQLException {
		SuspectsDao dao = new SuspectsDaoImpl();
		System.out.println("Enter Suspect Name : ");
		List<Suspects> suspectList = dao.searchSuspectByName(sc.next());
		
		for (Suspects suspect : suspectList) {
			System.out.println(suspect);
		}
	}
	
	public static void addSuspects() throws ClassNotFoundException, SQLException {
		Suspects suspect = new Suspects();
		SuspectsDao dao = new SuspectsDaoImpl();
		System.out.println("Enter SuspectId : ");
		suspect.setSuspectId(sc.nextInt());
		System.out.println("Enter First Name : ");
		suspect.setFirstName(sc.next());
		System.out.println("Enter Last Name : ");
		suspect.setLastName(sc.next());
		System.out.println("Enter Date Of Birth : ");
		String s1 = sc.next();
		Date d1 = Date.valueOf(s1);
		suspect.setDateOfBirth(d1);
		System.out.println("Enter Gender : ");
		suspect.setGender(Gender.valueOf(sc.next()));
		System.out.println("Enter Email : ");
		suspect.setEmail(sc.next());
		System.out.println("Enter Phone Number : ");
		suspect.setPhoneNumber(sc.next());
		System.out.println(dao.addSuspects(suspect));
	}
	
	public static void showSuspectsByIncident() throws ClassNotFoundException, SQLException {
		SuspectsDao dao = new SuspectsDaoImpl();
		System.out.println("Enter Incident Type : ");
		List<Suspects> suspectList = dao.showSuspectsByIncident(sc.next());
		
		for (Suspects suspect : suspectList) {
			System.out.println(suspect);
		}
	}
	public static void showVictimsByIncident() throws ClassNotFoundException, SQLException {
		VictimsDao dao = new VictimsDaoImpl();
		System.out.println("Enter Incident Type : ");
		List<Victims> victimList = dao.showVictimsByIncident(sc.next());
		for (Victims victim : victimList) {
			System.out.println(victim);
		}
	}
	
	public static void showReports() throws ClassNotFoundException, SQLException {
		ReportsDao dao = new ReportsDaoImpl();
		List<Reports> reportList = dao.showReports();
		
		for (Reports reports : reportList) {
			System.out.println(reports);
		}
	}
	public static void searchByReportId() throws ClassNotFoundException, SQLException {
		ReportsDao dao = new ReportsDaoImpl();
		System.out.println("Enter ReportId : ");
		System.out.println(dao.searchByReportId(sc.nextInt()));
	}
	
	public static void showReportsByIncident() throws ClassNotFoundException, SQLException {
		ReportsDao dao = new ReportsDaoImpl();
		System.out.println("Enter Incident Type : ");
		List<Reports> reportList = dao.showReportsByIncident(sc.next());
		for (Reports reports : reportList) {
			System.out.println(reports);
		}
	}
	public static void showUnderInvestigationReports() throws ClassNotFoundException, SQLException {
		ReportsDao dao = new ReportsDaoImpl();
		List<Reports> reportList = dao.showUnderInvestigationReports();
		for (Reports reports : reportList) {
			System.out.println(reports);
		}
	}
	public static void showClosedReports() throws ClassNotFoundException, SQLException {
		ReportsDao dao = new ReportsDaoImpl();
		List<Reports> reportList = dao.showClosedReports();
		for (Reports reports : reportList) {
			System.out.println(reports);
		}
	}
	public static void searchByEvidenceId() throws ClassNotFoundException, SQLException {
		EvidenceDao dao = new EvidenceDaoImpl();
		System.out.println("Enter EvidenceId : ");
		System.out.println(dao.searchByEvidenceId(sc.nextInt()));
	}
	public static void showEvidenceByIncident() throws ClassNotFoundException, SQLException {
	    EvidenceDao dao = new EvidenceDaoImpl();
	    System.out.println("Enter IncidentId : ");
	    List<Evidence> evidenceList = dao.showEvidenceByIncident(sc.nextInt());
	    for (Evidence evidence : evidenceList) {
	        System.out.println(evidence);
	    }
	}
	public static void addEvidence() throws ClassNotFoundException, SQLException {
	    Evidence evidence = new Evidence();
	    EvidenceDao dao = new EvidenceDaoImpl();
	    System.out.println("Enter EvidenceId : ");
	    evidence.setEvidenceId(sc.nextInt());
	    System.out.println("Enter Description : ");
	    evidence.setDescription(sc.next());
	    System.out.println("Enter City : ");
	    evidence.setCity(sc.next());
	    System.out.println("Enter IncidentId : ");
	    evidence.setIncidentId(sc.nextInt());
	    System.out.println(dao.addEvidence(evidence));
	}

	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("1. Show Victims");
			System.out.println("2. Search by victimid");
			System.out.println("3. Search By VictimName");
			System.out.println("4. Add Victim");
			System.out.println("5. Show Suspects");
			System.out.println("6. Search By Suspect Name");
			System.out.println("7. Add Suspect Name");
			System.out.println("8. Add LawEnforecementAgentcies");
			System.out.println("9. Add Incident");
			System.out.println("10. Show Incident By Type");
			System.out.println("11. Show All suspects by IncidentType");
			System.out.println("12. Show All Victims by IncidentType");
			System.out.println("13. Search By Evidence id ");
			System.out.println("14. Show All evidences for particular incidentid");
			System.out.println("15. Add Evidence ");
			System.out.println("16. Show All Reports ");
			System.out.println("17. Search By ReportId  ");
			System.out.println("18. Show All reports based on Incident Type ");
			System.out.println("19. Show ALl reports whose status is 'UNDER_INVESTIGATION' ");
			System.out.println("20. Show All Reports whose status is 'CLOSED'");
			System.out.println("21. Exit ");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			System.out.println("\n");
			switch(choice) {
			
			case 1:
				try {
					showVictims();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 2:
				try {
					searchByVictimId();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					searchByVictimName();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 4:
				try {
					addVictim();
				} catch (ClassNotFoundException | SQLException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					showSuspect();
				} catch (SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 6:
				try {
					searchSuspectByName();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 7:
				try {
					addSuspects();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 8:
				try {
					addLawEnforcement();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 9:
				try {
					addIncidents();
				} catch (ClassNotFoundException | ParseException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 10:
				try {
					showIncidentByType();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 11:
				try {
					showSuspectsByIncident();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 12:
				try {
					showVictimsByIncident();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 13:
				try {
					searchByEvidenceId();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 14:
				try {
					showEvidenceByIncident();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 15:
				try {
					addEvidence();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 16:
				try {
					showReports();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 17:
				try {
					searchByReportId();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 18:
				try {
					showReportsByIncident();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 19:
				try {
					showUnderInvestigationReports();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 20:
				try {
					showClosedReports();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			} 
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------");	
		}while(choice!= 21);
	}
}
