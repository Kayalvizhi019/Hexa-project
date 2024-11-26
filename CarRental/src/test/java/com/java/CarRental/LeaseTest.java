package com.java.CarRental;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import com.java.CarRental.model.Lease;
import com.java.CarRental.model.Type;

public class LeaseTest {
	
	@Test
	public void testToString() {
	
		
		Lease lease1 = new Lease(1,1, 1,Date.valueOf("2003-10-10"),Date.valueOf("2004-08-10"),Type.DAILYLEASE);
		String Result ="Lease [leaseID=1, vehicleID=1, customerID=1, startDate=2003-10-10, endDate=2004-08-10, type=DAILYLEASE]";
		assertEquals(Result,lease1.toString());
		
	}
		
		
		@Test
		public void testgettersandsetters() {
			Lease lease = new Lease();
			lease.setLeaseID(1);
			lease.setVehicleID(1);
			lease.setCustomerID(1);
			lease.setStartDate(Date.valueOf("2003-10-10"));
			lease.setEndDate(Date.valueOf("2004-08-10"));
			lease.setType(Type.DAILYLEASE);
			
			assertEquals(1, lease.getLeaseID());
			assertEquals(1,lease.getVehicleID());
			assertEquals(1,lease.getCustomerID());
			assertEquals(Date.valueOf("2003-10-10"),lease.getStartDate());
			assertEquals(Date.valueOf("2004-08-10"),lease.getEndDate());
			assertEquals(Type.DAILYLEASE,lease.getType());
		}

	@Test
	public void testConstructor() {
		Lease lease = new Lease();
		assertNotNull(lease);
	    String s1= "2003-10-10";
	    String s2 ="2004-08-10";
	    Date dt = Date.valueOf(s1);
	    Date dt1 = Date.valueOf(s2);
	    
	    
	    Lease lease1 = new Lease(1,1,1,dt,dt1,Type.DAILYLEASE);
	    assertEquals(1,lease1.getLeaseID());
	    assertEquals(1,lease1.getVehicleID());
	    assertEquals(1,lease1.getCustomerID());
	    assertEquals(Date.valueOf("2003-10-10"),lease1.getStartDate());
	    assertEquals(Date.valueOf("2004-08-10"),lease1.getEndDate());
	    assertEquals(Type.DAILYLEASE,lease1.getType());
	    
		
	}

}