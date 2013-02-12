package com.insidecoding.sos.sample;

import java.util.List;

import org.junit.Test;

import com.insidecoding.sos.db.DBUtils;
import com.insidecoding.sos.junit.AbstractSoSBase;

public class TestGoogleWithDB extends AbstractSoSBase {

	@Test
	public void testWithDB() throws Exception {
		DBUtils dbUtils = new DBUtils("com.mysql.jdbc.Driver",
				"jdbc:mysql://localhost:3306/foosball", "root", "password");

		List<List<String>> matches = dbUtils.doSelect("SELECT * from matches");

		System.out.println(matches);

		// take the data and use it in tests now
	}

	@Override
	protected void doAdditionalSetUp() {
		// no need
	}

	@Override
	protected void doAdditionalTearDown() {
		// no need
	}
}
