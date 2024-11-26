package com.java.CarRental.model;

public class Vehicle {
	private int vehicleId;
	private String make;
	private String model;
	private String year;
	private Double dailyRate;
	private Status status;
	private  int passenegerCapacity;
	private int engineCapacity ;
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Double getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(Double dailyRate) {
		this.dailyRate = dailyRate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public int getPassenegerCapacity() {
		return passenegerCapacity;
	}
	public void setPassenegerCapacity(int passenegerCapacity) {
		this.passenegerCapacity = passenegerCapacity;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(int vehicleId, String make, String model, String year, Double dailyRate, Status status,
			int passenegerCapacity, int engineCapacity) {
		super();
		this.vehicleId = vehicleId;
		this.make = make;
		this.model = model;
		this.year = year;
		this.dailyRate = dailyRate;
		this.status = status;
		this.passenegerCapacity = passenegerCapacity;
		this.engineCapacity = engineCapacity;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", dailyRate=" + dailyRate + ", status=" + status + ", passenegerCapacity=" + passenegerCapacity
				+ ", engineCapacity=" + engineCapacity + "]";
	}
	

}

