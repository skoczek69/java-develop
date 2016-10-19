package com.wmiiul.lab2.dao;

import com.wmiiul.lab2.pojo.EDaoFactory;
import com.wmiiul.lab2.pojo.Person;

public class XML implements IDaoFactory {

	private static XML xml = null;

	public static XML getInstance() {
		if (xml == null) {
			xml = new XML();
		}
		return xml;
	}

	private XML() {
	}

	@Override
	public void setSource(EDaoFactory source) {
		// Method stub
	}

	@Override
	public Person getPersonByID(int id) {
		return new Person("Dominik", 33);
	}
}
