package com.java.CrimeReport;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.CrimeReport.model.Evidence;

public class EvidenceTest {
	
	@Test
	public void testToString() {
		
		Evidence evidence1 = new Evidence(1,"Jewels with fingerprint","Chennai",1);
		String result = "EvidenceModel [evidenceId=1, description=Jewels with fingerprint, city=Chennai, incidentID=1]";
		assertEquals(result, evidence1.toString());
		
	}

	@Test
	public void testConstructor() {
		Evidence evidence = new Evidence();
		assertNotNull(evidence); 
		
		Evidence evidence1 = new Evidence(1,"Jewels with finger print","Chennai", 1);
		assertEquals(1,evidence1.getEvidenceId());
		assertEquals("Jewels with finger print", evidence1.getDescription());
		assertEquals("Chennai",evidence1.getCity());
		assertEquals(1,evidence1.getIncidentId());
	}
	
	@Test
	public void testgettersandsetters() {
		Evidence evidence = new Evidence();
		evidence.setEvidenceId(1);
		evidence.setDescription("Jewels with finger print");
		evidence.setCity("Chennai");
		evidence.setIncidentId(1);
		assertEquals(1,evidence.getEvidenceId());
		assertEquals("Jewels with finger print",evidence.getDescription());
		assertEquals("Chennai",evidence.getCity());
		assertEquals(1,evidence.getIncidentId());
	}

}