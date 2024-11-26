package com.java.CarRental.main;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import com.java.CarRental.dao.VehicleDaoImpl;
import com.java.CarRental.dao.CustomerDaoImpl;
import com.java.CarRental.dao.PaymentDaoImpl;
import com.java.CarRental.dao.PaymentDao;
import com.java.CarRental.dao.LeaseDaoImpl;
import com.java.CarRental.dao.LeaseDao;
import com.java.CarRental.Exception.VehicleNotFoundException;
import com.java.CarRental.dao.CustomerDao;
import com.java.CarRental.model.Customer;
import com.java.CarRental.model.Lease;
import com.java.CarRental.model.Payment;
import com.java.CarRental.model.Status;
import com.java.CarRental.model.Type;
import com.java.CarRental.model.Vehicle;


import com.java.CarRental.dao.VehicleDao;

public class CarRentalMain {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void addVehicle() throws ClassNotFoundException, SQLException {
		VehicleDao Dao = new VehicleDaoImpl();
		Vehicle vehicle = new Vehicle();
		System.out.println("Enter VehicleId : ");
		vehicle.setVehicleId(sc.nextInt());
		System.out.println("Enter Make : ");
		vehicle.setMake(sc.next());
		System.out.println("Enter Model : ");
		vehicle.setModel(sc.next());
		System.out.println("Enter Year : ");
		vehicle.setYear(sc.next());
		System.out.println("Enter Daily Rate : ");
		vehicle.setDailyRate(sc.nextDouble());
		System.out.println("Enter Status : ");
		vehicle.setStatus(Status.valueOf(sc.next()));
		System.out.println("Enter Passeneger Capacity : ");
		vehicle.setPassenegerCapacity(sc.nextInt());
		System.out.println("Enter Engine Capacity : ");
		vehicle.setEngineCapacity(sc.nextInt());
		System.out.println(Dao.addVehicle(vehicle));
	}
	public static void searchByVehicleId() throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		VehicleDao Dao = new VehicleDaoImpl();
		System.out.println("Enter Vehicle ID : ");
		int VehicleId = sc.nextInt();
		System.out.println(Dao.searchByVehicleId(VehicleId));
		
	}
	public static void addCustomer() throws ClassNotFoundException, SQLException {
		CustomerDao Dao = new CustomerDaoImpl();
		Customer customer = new Customer();
		System.out.println("Enter CustomerId : ");
		customer.setCustomerId(sc.nextInt());
		System.out.println("Enter First Name : ");
		customer.setFirstName(sc.next());
		System.out.println("Enter Last Name : ");
		customer.setLastName(sc.next());
		System.out.println("Enter Email : ");
		customer.setEmail(sc.next());
		System.out.println("Enter Phone Number : ");
		customer.setPhoneNumber(sc.next());
		System.out.println(Dao.addCustomer(customer));
	}
	public static void showVehicleByEngine() throws SQLException, ClassNotFoundException {
		VehicleDao dao = new VehicleDaoImpl();
		System.out.println("Enter Engine Capacity : ");
		List<Vehicle> vehicleList = dao.showVehicleByEngine(sc.next());
		
		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle);
		}
	}
	public static void showCustomer() throws ClassNotFoundException, SQLException {
		CustomerDao dao = new CustomerDaoImpl();
		List<Customer> customerList = dao.showCustomer();
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
	}
	public static void searchCustomer() throws ClassNotFoundException, SQLException {
		CustomerDao Dao = new CustomerDaoImpl();
		System.out.println("Enter Customer ID : ");
		System.out.println(Dao.searchCustomer(sc.nextInt()));
	}
	
	public static void addLease() throws ClassNotFoundException, SQLException {
		LeaseDao Dao = new LeaseDaoImpl();
		Lease lease = new Lease();
		System.out.println("Enter LeaseId : ");
		lease.setLeaseID(sc.nextInt());
		System.out.println("Enter VehicleID : ");
		lease.setVehicleID(sc.nextInt());
		System.out.println("Enter CustomerId : ");
		lease.setCustomerID(sc.nextInt());
		System.out.println("Enter Start Date : ");
		String s1 = sc.next();
		Date d1 = Date.valueOf(s1);
		lease.setStartDate(d1);
		System.out.println("Enter End Date : ");
		String s2 = sc.next();
		Date d2 = Date.valueOf(s2);
		lease.setEndDate(d2);
		System.out.println("Enter Type : ");
		lease.setType(Type.valueOf(sc.next()));
		System.out.println(Dao.addLease(lease));
	}
	public static void showPaymentsByLeaseId() throws ClassNotFoundException, SQLException {
		PaymentDao dao = new PaymentDaoImpl();
		System.out.println("Enter LeaseId : ");
		List<Payment> paymentList = dao.showPaymentsByLeaseId(sc.nextInt());
		for (Payment payment : paymentList) {
			System.out.println(payment);
		}

	}
	
	public static void showPayments() throws ClassNotFoundException, SQLException {
		PaymentDao dao = new PaymentDaoImpl();
		System.out.println("Enter LeaseId : ");
		List<Payment> paymentList = dao.showPayments();
		for (Payment payment : paymentList) {
			System.out.println(payment);
		}
	}
	public static void showLeaseByStartDate() throws ClassNotFoundException, SQLException {
		LeaseDao dao = new LeaseDaoImpl();
		System.out.println("Enter Start Date : ");
		List<Lease> leaseList = dao.showLeaseByStartDate(sc.next());
		for (Lease lease : leaseList) {
			System.out.println(lease);
		}

		
	}
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("1. Add Vehicle");
			System.out.println("2. Search Vehicle");
			System.out.println("3. Show by capacity");
			System.out.println("4. Add Customer");
			System.out.println("5. Show Customer");
			System.out.println("6. Search Customer");
			System.out.println("7. Add Lease");
			System.out.println("8. Show Lease from Start Date");
			System.out.println("9. Show Payments");
			System.out.println("10. Show Payment Details By leaseID");
			System.out.println("11. Exit ");
			System.out.print("Enter your choice : ");
			choice = sc.nextInt();
			System.out.println("\n");
			switch(choice) {
			
			case 1:
				try {
					addVehicle();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 2:
				try {
					searchByVehicleId();
				} catch (ClassNotFoundException | SQLException | VehicleNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case 3:
				try {
					showVehicleByEngine();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					addCustomer();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					showCustomer();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				try {
					searchCustomer();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					addLease();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				try {
					showLeaseByStartDate();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 9:
				try {
					showPaymentsByLeaseId();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 10:
				try {
					showPayments();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------");	
		}while(choice!= 11);
	}

}
