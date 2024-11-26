package com.java.CarRental;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.CarRental.model.Status;
import com.java.CarRental.model.Vehicle;

public class VehicleTest {
	
	
	@Test
	public void testconstructor() {
		Vehicle vechile = new Vehicle();
		assertNotNull(vechile);
		Vehicle vehicle1 = new Vehicle(1, "bmw", "A3", "2023", 3000.00, Status.AVAILABLE, 4, 1500);
		assertEquals(1,vehicle1.getVehicleId());
		assertEquals("bmw",vehicle1.getMake());
		assertEquals("A3",vehicle1.getModel());
		assertEquals("2023", vehicle1.getYear());
		assertEquals(3000.00, vehicle1.getDailyRate(),0.00001);
		assertEquals(Status.AVAILABLE,vehicle1.getStatus());
		assertEquals(4,vehicle1.getPassenegerCapacity());
		assertEquals(1500,vehicle1.getEngineCapacity());
	}
	
	@Test
	public void testgetterandsetter(){
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleId(1);
		vehicle.setMake("bmw");
		vehicle.setModel("A3");
		vehicle.setYear("2023");
		vehicle.setDailyRate(3000.00);
		vehicle.setStatus(Status.AVAILABLE);
		vehicle.setPassenegerCapacity(4);
		vehicle.setEngineCapacity(1500);
		assertEquals(1,vehicle.getVehicleId());
		assertEquals("bmw",vehicle.getMake());
		assertEquals("A3",vehicle.getModel());
		assertEquals("2023", vehicle.getYear());
		assertEquals(3000.00, vehicle.getDailyRate(),0.00001);
		assertEquals(Status.AVAILABLE,vehicle.getStatus());
		assertEquals(4,vehicle.getPassenegerCapacity());
		assertEquals(1500,vehicle.getEngineCapacity());
	}
	@Test
	public void testtistring() {
		
		Vehicle vehicle1 = new Vehicle(1, "bmw", "A3", "2023", 3000.00, Status.AVAILABLE, 4, 1500);
		String result = "Vehicle [vehicleId=1, make=bmw, model=A3, year=2023, dailyRate=3000.0, status=AVAILABLE, passenegerCapacity=4, engineCapacity=1500]";
		assertEquals(result,vehicle1.toString());
		}


}
