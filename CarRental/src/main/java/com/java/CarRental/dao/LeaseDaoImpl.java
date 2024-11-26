package com.java.CarRental.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.CarRental.model.Customer;
import com.java.CarRental.model.Lease;
import com.java.CarRental.model.Status;
import com.java.CarRental.model.Type;
import com.java.CarRental.model.Vehicle;
import com.java.CarRental.util.ConnectionHelper;



public class LeaseDaoImpl implements LeaseDao {

	
	Connection connection;
	PreparedStatement pst;

	@Override
	public String addLease(Lease lease) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
	    String cmd = "INSERT INTO LEASE (LeaseId, VehicleId, "
	    		+ "CustomerId, StartDate, EndDate, Type) VALUES (?,?,?,?,?,?)";
	    pst = connection.prepareStatement(cmd);
	    pst.setInt(1, lease.getLeaseID());
	    pst.setInt(2, lease.getVehicleID());
	    pst.setInt(3, lease.getCustomerID());
	    pst.setDate(4, lease.getStartDate());
	    pst.setDate(5, lease.getEndDate());
	    pst.setString(6, lease.getType().toString());
	    pst.executeUpdate();
	    return "Lease added......";
	}

	@Override
	public List<Lease> showLeaseByStartDate(String date) throws ClassNotFoundException, SQLException {
		Lease lease = null;
		connection = ConnectionHelper.getConnection();
		List<Lease> leaseList = new ArrayList<>();
		String cmd = "SELECT * FROM LEASE where StartDate >= ?";
		pst = connection.prepareStatement(cmd);
		Date d1 = Date.valueOf(date);
		pst.setDate(1, d1);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			lease = new Lease();
			lease.setLeaseID(rs.getInt("LeaseId"));
			lease.setVehicleID(rs.getInt("VehicleId"));
			lease.setCustomerID(rs.getInt("CustomerID"));
			lease.setStartDate(rs.getDate("StartDate"));
			lease.setEndDate(rs.getDate("EndDate"));
			lease.setType(Type.valueOf(rs.getString("Type").toUpperCase()));
			leaseList.add(lease);
		}
		return leaseList;

	}


}
