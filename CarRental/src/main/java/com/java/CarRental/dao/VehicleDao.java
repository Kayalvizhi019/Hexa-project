package com.java.CarRental.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.CarRental.Exception.VehicleNotFoundException;
import com.java.CarRental.model.Vehicle;

public interface VehicleDao {

	String addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException;
	Vehicle searchByVehicleId(int vehicleId) throws ClassNotFoundException, SQLException, VehicleNotFoundException;
	List<Vehicle> showVehicleByEngine(String engine) throws SQLException, ClassNotFoundException;
}
