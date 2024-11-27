package com.java.CrimeReport;

import static org.junit.Assert.*;


import org.junit.Test;

import com.java.CrimeReport.model.Reports;
import com.java.CrimeReport.model.Status;


import java.sql.Date;


public class ReportsTest {

	@Test
	public void testconstructor() {
		Reports report = new Reports();
		assertNotNull(report);
		String s1 = "2024-03-03";
		Date d1 = Date.valueOf(s1);
		Reports report1 = new Reports(1, 1, 1,d1,"robbery",Status.OPEN);
		assertEquals(1, report1.getIncidentId());
		assertEquals(1, report1.getReportId());
		assertEquals(1, report1.getReportingOfficer());
		assertEquals(d1, report1.getReportDate());
		assertEquals("robbery",report1.getReportDetails() );
		assertEquals(Status.OPEN,report1.getStatus() );
	}
	@Test
	public void getterandsetter() {
		Reports report = new Reports();
		String s1 = "2024-03-03";
		Date d1 = Date.valueOf(s1);
		report.setIncidentId(1);
		report.setReportId(1);
		report.setReportingOfficer(1);
		report.setReportDetails("robbery");
		report.setReportDate(d1);
		report.setStatus(Status.OPEN);
		assertEquals(1,report.getIncidentId());
		assertEquals(1,report.getReportId());
		assertEquals(1,report.getReportingOfficer());
		assertEquals(d1,report.getReportDate());
		assertEquals("robbery", report.getReportDetails());
		assertEquals(Status.OPEN,report.getStatus());
	}
	@Test
	public void testtostring() {
		String s1 = "2024-03-03";
		Date d1 = Date.valueOf(s1);
		Reports report1 = new Reports(1, 1, 1,d1,"robbery",Status.OPEN);
		String result ="Reports [reportId=1, incidentId=1, reportingOfficer=1, reportDate=2024-03-03, reportDetails=robbery, status=OPEN]";
		assertEquals(result,report1.toString());
	}

}
