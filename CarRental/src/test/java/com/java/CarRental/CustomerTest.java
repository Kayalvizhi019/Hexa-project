package com.java.CarRental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Test;

import com.java.CarRental.model.Customer;

public class CustomerTest {
	
	@Test
	public void testgettersandsetters()
	{
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("Kayal");
		customer.setLastName("vizhi");
		customer.setEmail("kayal@gmail.com");
		customer.setPhoneNumber("8778849377");
		assertEquals(1, customer.getCustomerId());
		assertEquals("Kayal", customer.getFirstName());
		assertEquals("vizhi", customer.getLastName());
		assertEquals("kayal@gmail.com", customer.getEmail());
		assertEquals("8778849377", customer.getPhoneNumber());
		
	}
	
	@Test
	public void testconstructor() throws ParseException {
		
		Customer customer = new Customer();
		assertNotNull(customer);
		Customer customer1 = new Customer(1, "Kayal" , "vizhi" , "kayal@gmail.com", "8778849377");
		assertEquals(1, customer1.getCustomerId());
		assertEquals("Kayal", customer1.getFirstName());
		assertEquals("vizhi", customer1.getLastName());
		assertEquals("kayal@gmail.com", customer1.getEmail());
		assertEquals("8778849377", customer1.getPhoneNumber());
	}
	
	@Test
	public void testtoString()
	{
		
		Customer customer1 = new Customer(1, "Kayal" , "vizhi" , "kayal@gmail.com", "8778849377");
		String result = "Customer [customerId=1, firstName=Kayal, lastName=vizhi, email=kayal@gmail.com, phoneNumber=8778849377]";
		assertEquals(result, customer1.toString());
			
	}

}

