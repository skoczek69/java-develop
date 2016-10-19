package com.wmiiul.lab2.dao;

import com.wmiiul.lab2.pojo.EDaoFactory;
import com.wmiiul.lab2.pojo.Person;

public class WS implements IDaoFactory {

	private static WS ws = null;

	public static WS getInstance() {
		if (ws == null) {
			ws = new WS();
		}
		return ws;
	}

	private WS() {
	}

	@Override
	public void setSource(EDaoFactory source) {
		// Method stub
	}

	@Override
	public Person getPersonByID(int id) {
		return new Person("Jacek", 22);
	}
}
