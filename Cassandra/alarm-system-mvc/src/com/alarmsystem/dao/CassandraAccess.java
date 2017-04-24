package com.alarmsystem.dao;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraAccess {
	private static Session instance = null;

	public static Session getInstance() {

		if (instance == null) {
			instance = createSession();
		}

		return instance;
	}

	protected static Session createSession() {
		Cluster cluster = Cluster.builder().addContactPoint("localhost").build();
		Session session = cluster.connect();

		return session;
	}
}
