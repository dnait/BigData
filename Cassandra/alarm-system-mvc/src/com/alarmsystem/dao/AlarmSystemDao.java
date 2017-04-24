package com.alarmsystem.dao;

import java.util.Iterator;
import java.util.LinkedList;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class AlarmSystemDao {
	
	private Session session = null;
	private ResultSet result = null;
	private ResultSet result_hometable = null;
	private LinkedList <GetsSetsActivity> resultList;
	private LinkedList <GetsSetsHome> resultList_hometable;
	
	public AlarmSystemDao(String homeId) {
		getData(homeId);
	}

	protected void getData(String homeId) {
		session = CassandraAccess.getInstance();
		String queryString = "SELECT datetime, event, code_used FROM home_security.activity WHERE home_id = '" + homeId + "'";
		String queryString_hometable = "SELECT contact_name, address, city, state, zip FROM home_security.home WHERE home_id = '" + homeId + "'";
		result = session.execute(queryString);
		result_hometable = session.execute(queryString_hometable);
		resultList = new LinkedList<GetsSetsActivity>();
		resultList_hometable = new LinkedList<GetsSetsHome>();
		
		for (Row row : result) {
			GetsSetsActivity activity = new GetsSetsActivity();
			activity.setDatetime(row.getDate("datetime").toString());
			activity.setEvent(row.getString("event"));

			resultList.add(activity);
		}
		
		for (Row row : result_hometable) {
			GetsSetsHome home = new GetsSetsHome();
			home.setContactName(row.getString("contact_name"));
			home.setAddress(row.getString("address"));
			home.setCity(row.getString("city"));
			home.setState(row.getString("state"));
			home.setZip(row.getString("zip"));

			resultList_hometable.add(home);
		}
	}

	public Iterator <GetsSetsActivity> getResultIterator() {
		return resultList.iterator();
	}	
	public Iterator <GetsSetsHome> getResultIteratorHome() {
		return resultList_hometable.iterator();
	}
}
