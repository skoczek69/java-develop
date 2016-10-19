package com.wmiiul.lab2.dao;

import com.wmiiul.lab2.pojo.EDaoFactory;
import com.wmiiul.lab2.pojo.Person;

public class DB implements IDaoFactory {

	private static DB db = null;

	public static DB getInstance() {
		if (db == null) {
			db = new DB();
		}
		return db;
	}

	private DB() {
	}

	@Override
	public void setSource(EDaoFactory source) {
		// Method stub
	}

	@Override
	public Person getPersonByID(int id) {
		return new Person("Robert", 26);
	}
}
