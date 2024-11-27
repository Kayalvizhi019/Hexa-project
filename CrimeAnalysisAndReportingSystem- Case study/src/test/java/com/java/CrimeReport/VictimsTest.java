package com.java.CrimeReport;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import org.junit.Test;

import com.java.CrimeReport.model.Gender;
import com.java.CrimeReport.model.Victims;

public class VictimsTest {

	
	
	@Test
	public void testgettersandsetters() throws ParseException {
		Victims victim = new Victims();
		victim.setVictimId(1);
		victim.setFirstName("rolex");
		victim.setLastName("Dhilli");
		victim.setGender(Gender.MALE);
		String s1 = "2003-10-10";
		Date d1 = Date.valueOf(s1);
		victim.setDateOfBirth(d1);
	    victim.setEmail("rolex@gmail.com");
	    victim.setPhoneNumber("893793922");
	    
	   
	}

	@Test
	public void testconstructor() throws ParseException {
		Victims victim=new Victims();
		assertNotNull(victim);
		String s1 = "2003-10-10";
		Date d1 = Date.valueOf(s1);
		Victims victim1 = new Victims(1,"Rolex","Dhilli", d1,Gender.MALE,"rolex@gmail.com","893793922");
		assertEquals(1,victim1.getVictimId());
		assertEquals("Rolex",victim1.getFirstName());
		assertEquals("Dhilli",victim1.getLastName());
		assertEquals(d1,victim1.getDateOfBirth());
		assertEquals(Gender.MALE, victim1.getGender());
		assertEquals("rolex@gmail.com",victim1.getEmail());
		assertEquals("893793922",victim1.getPhoneNumber());
		
	}
	@Test
	public void testtostring() throws ParseException {
		String s1 = "2003-10-10";
		Date d1 = Date.valueOf(s1);
	    
		Victims victim1 = new Victims(1,"Rolex","Dhilli", d1,Gender.MALE,"rolex@gmail.com","893793922");

		String result = "Victims [victimId=1, firstName=Rolex, lastName=Dhilli, dateOfBirth=2003-10-10, "
				+ "gender=MALE, email=rolex@gmail.com, phoneNumber=893793922]";
		
		assertEquals(result,victim1.toString());
	}
	
	
}
	
	
	
	


