package com.java.CrimeReport;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.CrimeReport.model.Officers;

public class OfficersTest {
	
	@Test
	public void testToString() {
		
		Officers off1 = new Officers(1,"Leo","Das",111,"Inspector","leo@gmail.com","1234567890",1);
		String result = "Officers [officerId=1, firstName=Leo, lastName=Das, badgeNumber=111, ranks=Inspector, email=leo@gmail.com, phoneNumber=1234567890, agencyId=1]";
		assertEquals(result,off1.toString());
		
}
	
	@Test 
	public void testgettersandsetters() {
		
		Officers off = new Officers();
		off.setOfficerId(1);
		off.setFirstName("Leo");
		off.setLastName("Das");
		off.setBadgeNumber(111);;
		off.setPhoneNumber("1234567890");
		off.setEmail("leo@gmail.com");
		off.setRanks("Inspector");
		off.setAgencyId(1);
		assertEquals(1, off.getOfficerId());
		assertEquals("Leo",off.getFirstName());
		assertEquals("Das",off.getLastName());
		assertEquals(111,off.getBadgeNumber());
		assertEquals("1234567890",off.getPhoneNumber());
		assertEquals("leo@gmail.com",off.getEmail());
		assertEquals("Inspector",off.getRanks());
		assertEquals(1,off.getAgencyId());
		
	}

	@Test
	public void testConstructor() {

		Officers off = new Officers();
		assertNotNull(off);
		
		Officers off1 = new Officers(1,"Leo","Das",111,"Inspector","leo@gmail.com","1234567890",1);
		assertEquals(1,off1.getOfficerId());
		assertEquals("Leo",off1.getFirstName());
		assertEquals("Das",off1.getLastName());
		assertEquals(111,off1.getBadgeNumber());
		assertEquals("Inspector",off1.getRanks());
		assertEquals("leo@gmail.com",off1.getEmail());
		assertEquals("1234567890",off1.getPhoneNumber());
		assertEquals(1,off1.getAgencyId());
		
	}

}

