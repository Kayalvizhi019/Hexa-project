package com.java.CrimeReport;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.CrimeReport.model.LawEnforcementAgencies;

public class LawEnforcementAgenciesTest {

	@Test
	public void testgettersandsetters() {
		LawEnforcementAgencies lea = new LawEnforcementAgencies();
		lea.setAgencyId(1);
		lea.setAgencyName("Misbah");
		lea.setEmail("noorulmisbah15@gmail.com");
		lea.setJurisdiction("Chennai");
		lea.setPhoneNumber("8754026630");
		assertEquals(1, lea.getAgencyId());
		assertEquals("Misbah", lea.getAgencyName());
		assertEquals("Chennai", lea.getJurisdiction());
		assertEquals("noorulmisbah15@gmail.com", lea.getEmail());
		assertEquals("8754026630", lea.getPhoneNumber());
	}
	@Test
	public void testconstructor() {
		LawEnforcementAgencies lea = new LawEnforcementAgencies();
		assertNotNull(lea);
		LawEnforcementAgencies lea1 = new LawEnforcementAgencies(1, "Misbah", "Chennai", "noorulmisbah15@gmail.com", "8754026630");
		assertEquals(1, lea1.getAgencyId());
		assertEquals("Misbah", lea1.getAgencyName());
		assertEquals("Chennai", lea1.getJurisdiction());
		assertEquals("noorulmisbah15@gmail.com", lea1.getEmail());
		assertEquals("8754026630", lea1.getPhoneNumber());
	}
	@Test
	public void testtoString() {
		LawEnforcementAgencies lea = new LawEnforcementAgencies();
		lea.setAgencyId(1);
		lea.setAgencyName("Misbah");
		lea.setEmail("noorulmisbah15@gmail.com");
		lea.setJurisdiction("Chennai");
		lea.setPhoneNumber("8754026630");
		String result = "LawEnforcementAgencies [agencyId=1, agencyName=Misbah, jurisdiction=Chennai, "
				+ "email=noorulmisbah15@gmail.com, phoneNumber=8754026630]";
		assertEquals(result, lea.toString());
	}

}
