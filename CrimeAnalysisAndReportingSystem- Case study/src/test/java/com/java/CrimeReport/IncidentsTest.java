package com.java.CrimeReport;

import static org.junit.Assert.*;


import java.text.ParseException;
import java.sql.Date;

import org.junit.Test;

import com.java.CrimeReport.model.Incidents;
import com.java.CrimeReport.model.Status;

public class IncidentsTest {
	
	@Test
	public void testgettersandsetters() throws ParseException {
		Incidents incidents = new Incidents();
		incidents.setIncidentId(1);
		incidents.setIncidentType("Robbery");
		String s1 = "2020-12-01";
		Date d1 = Date.valueOf(s1);
		incidents.setIncidentDate(d1);
		incidents.setCity("Chennai");
		incidents.setDescription("Robbed 10kg gold");
		incidents.setStatus(Status.OPEN);
		incidents.setSuspectId(1);
		incidents.setOfficerId(1);
		incidents.setVictimId(1);
		assertEquals(1, incidents.getIncidentId());
		assertEquals("Robbery", incidents.getIncidentType());
		assertEquals(d1, incidents.getIncidentDate());
		assertEquals("Chennai", incidents.getCity());
		assertEquals("Robbed 10kg gold", incidents.getDescription());
		assertEquals(Status.OPEN, incidents.getStatus());
		assertEquals(1, incidents.getVictimId());
		assertEquals(1, incidents.getOfficerId());
		assertEquals(1, incidents.getSuspectId());

	}

	@Test
	public void testconstructor() throws ParseException {
		Incidents incidents = new Incidents();
		assertNotNull(incidents);
		String s1 = "2020-12-01";
		Date d1 = Date.valueOf(s1);
		Incidents incidents1 = new Incidents(1,"Robbery" , d1, "Chennai", "Robbed 10kg Gold", Status.OPEN, 1, 1, 1);
		assertEquals(1, incidents1.getIncidentId());
		assertEquals("Robbery", incidents1.getIncidentType());
		assertEquals(d1, incidents1.getIncidentDate());
		assertEquals("Chennai", incidents1.getCity());
		assertEquals("Robbed 10kg Gold", incidents1.getDescription());
		assertEquals(Status.OPEN, incidents1.getStatus());
		assertEquals(1, incidents1.getVictimId());
		assertEquals(1, incidents1.getOfficerId());
		assertEquals(1, incidents1.getSuspectId());
	}
	
	@Test
	public void testtoString() throws ParseException {
		String result = "Incidents [incidentId=1, incidentType=Robbery, incidentDate=2020-12-01, city=Chennai, "
				+ "description=Robbed 10kg gold, status=OPEN, victimId=1, suspectId=1, officerId=1]";
		Incidents incidents = new Incidents();
		incidents.setIncidentId(1);
		incidents.setIncidentType("Robbery");
		String s1 = "2020-12-01";
		Date d1 = Date.valueOf(s1);
		incidents.setIncidentDate(d1);
		incidents.setCity("Chennai");
		incidents.setDescription("Robbed 10kg gold");
		incidents.setStatus(Status.OPEN);
		incidents.setSuspectId(1);
		incidents.setOfficerId(1);
		incidents.setVictimId(1);
		assertEquals(result, incidents.toString());
	}

}
