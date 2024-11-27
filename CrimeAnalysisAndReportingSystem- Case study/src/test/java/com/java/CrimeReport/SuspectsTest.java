package com.java.CrimeReport;

import static org.junit.Assert.*;


import java.sql.Date;
import java.text.ParseException;

import org.junit.Test;

import com.java.CrimeReport.model.Gender;
import com.java.CrimeReport.model.Suspects;


public class SuspectsTest {
	
	@Test
	public void testgettersandsetters()
	{
		Suspects suspects = new Suspects();
		suspects.setSuspectId(1);
		suspects.setFirstName("Kayal");
		suspects.setLastName("vizhi");
		suspects.setGender(Gender.FEMALE);
		suspects.setPhoneNumber("8778849377");
		suspects.setEmail("kayal@gmail.com");
		String s1 = "2024-10-10";
		Date d1 = Date.valueOf(s1);
		suspects.setDateOfBirth(d1);
		assertEquals(1, suspects.getSuspectId());
		assertEquals("Kayal", suspects.getFirstName());
		assertEquals("vizhi", suspects.getLastName());
		assertEquals(Gender.FEMALE, suspects.getGender());
		assertEquals("8778849377", suspects.getPhoneNumber());
		assertEquals("kayal@gmail.com", suspects.getEmail());
		assertEquals(d1, suspects.getDateOfBirth());
		
		
	}

	@Test
	public void testconstructor() throws ParseException {
		
		Suspects suspects = new Suspects();
		assertNotNull(suspects);
		String s1 = "2024-10-10";
		Date d1 = Date.valueOf(s1);
		Suspects suspects1 = new Suspects(1, "Kayal","vizhi",d1, Gender.FEMALE, "8778849377", "kayal@gmail.com"); 
		assertEquals(1, suspects1.getSuspectId());
		assertEquals("Kayal",suspects1.getFirstName());
		assertEquals("vizhi", suspects1.getLastName());
		assertEquals(Gender.FEMALE, suspects1.getGender());
		assertEquals("8778849377", suspects1.getPhoneNumber());
		assertEquals("kayal@gmail.com", suspects1.getEmail());
		assertEquals(d1, suspects1.getDateOfBirth());
		
	}
	
	@Test
	public void testtostring()
	{
		String s1 = "2024-10-10";
		Date d1 = Date.valueOf(s1);
		Suspects suspects1 = new Suspects(1, "Kayal","vizhi",d1, Gender.FEMALE, "8778849377", "kayal@gmail.com"); 
		String result = "Suspects [suspectId=1, firstName=Kayal, lastName=vizhi, dateOfBirth=2024-10-10, phoneNumber=8778849377, email=kayal@gmail.com]";
		assertEquals(result, suspects1.toString());	
	}
	
	

}
