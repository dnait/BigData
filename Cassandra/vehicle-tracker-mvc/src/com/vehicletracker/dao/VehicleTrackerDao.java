package com.vehicletracker.dao;

import java.util.Iterator;
import java.util.LinkedList;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class VehicleTrackerDao {
	
	private Session session = null;
	private ResultSet result = null;
	private LinkedList <GetsSets> resultList;
	
	public VehicleTrackerDao(String vehicleId, String trackDate) {
		getData(vehicleId, trackDate);
	}

	protected void getData(String vehicleId, String trackDate) {
		session = CassandraAccess.getInstance();
		String queryString = "SELECT time, latitude, longitude FROM vehicle_tracker.location WHERE vehicle_id = '" + vehicleId + "' AND date = '" + trackDate + "' LIMIT 1";
		result = session.execute(queryString);
		resultList = new LinkedList<GetsSets>();
		
		for (Row row : result) {
			GetsSets location = new GetsSets();
			location.setTime(row.getDate("time").toString());
			location.setLatitude(row.getDouble("latitude"));
			location.setLongitude(row.getDouble("longitude"));
			
			resultList.add(location);
		}
	}

	public Iterator <GetsSets> getResultIterator() {
		return resultList.iterator();
	}	
}
