package com.java.CarRental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CarRental.Exception.VehicleNotFoundException;
import com.java.CarRental.model.Status;
import com.java.CarRental.model.Vehicle;
import com.java.CarRental.util.ConnectionHelper;

public class VehicleDaoImpl implements VehicleDao {

	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String addVehicle(Vehicle vehicle) throws SQLException, ClassNotFoundException {
		connection = ConnectionHelper.getConnection();
	    String cmd = "INSERT INTO VEHICLE (VehicleId, Make, Model, Year, DailyRate, Status, PassenegerCapacity, EngineCapacity) VALUES (?,?,?,?,?,?,?,?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, vehicle.getVehicleId());
	    pst.setString(2, vehicle.getMake());
	    pst.setString(3, vehicle.getModel());
	    pst.setString(4, vehicle.getYear());
	    pst.setDouble(5, vehicle.getDailyRate());
	    pst.setString(6, vehicle.getStatus().toString());
	    pst.setInt(7, vehicle.getPassenegerCapacity());
	    pst.setInt(8, vehicle.getEngineCapacity());
	    pst.executeUpdate();
	    return "Vehicle added......";
	}

	@Override
	public Vehicle searchByVehicleId(int vehicleId) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		Vehicle vehicle = new Vehicle();
		connection = ConnectionHelper.getConnection();
		String cmd = "SELECT * FROM VEHICLE WHERE VEHICLEID = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vehicleId);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			vehicle.setVehicleId(rs.getInt("vehicleId"));
			vehicle.setMake(rs.getString("make"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setYear(rs.getString("year"));
			vehicle.setDailyRate(rs.getDouble("DailyRate"));
			vehicle.setStatus(Status.valueOf(rs.getString("status")));
			vehicle.setPassenegerCapacity(rs.getInt("PassenegerCapacity"));
			vehicle.setEngineCapacity(rs.getInt("EngineCapacity"));
		}
		if (vehicle.getVehicleId() == 0) {
			throw new VehicleNotFoundException("Vehicle Id Not Found");
		}
		return vehicle;
	}

	@Override
	public List<Vehicle> showVehicleByEngine(String engine) throws SQLException, ClassNotFoundException {
		Vehicle vehicle = null;
		connection = ConnectionHelper.getConnection();
		List<Vehicle> vehicleList = new ArrayList<>();
		String cmd = "SELECT * FROM VEHICLE WHERE ENGINECAPACITY >= ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, engine);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			vehicle = new Vehicle();
			vehicle.setVehicleId(rs.getInt("vehicleId"));
			vehicle.setMake(rs.getString("make"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setYear(rs.getString("year"));
			vehicle.setDailyRate(rs.getDouble("DailyRate"));
			vehicle.setStatus(Status.valueOf(rs.getString("status")));
			vehicle.setPassenegerCapacity(rs.getInt("PassenegerCapacity"));
			vehicle.setEngineCapacity(rs.getInt("EngineCapacity"));
			vehicleList.add(vehicle);
		}
		return vehicleList;
	}
}
