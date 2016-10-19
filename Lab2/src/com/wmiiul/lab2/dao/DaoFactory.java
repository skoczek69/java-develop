package com.wmiiul.lab2.dao;

import com.wmiiul.lab2.pojo.EDaoFactory;
import com.wmiiul.lab2.pojo.Person;

public class DaoFactory implements IDaoFactory {

	private EDaoFactory eDaoFactory;

	private DB db = DB.getInstance();

	private WS ws = WS.getInstance();

	private XML xml = XML.getInstance();

	private static DaoFactory daoFactory = null;

	public static DaoFactory getInstance() {
		if (daoFactory == null) {
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}

	private DaoFactory() {
		eDaoFactory = EDaoFactory.XML;
	}

	@Override
	public void setSource(EDaoFactory source) {
		eDaoFactory = source;
		switch (eDaoFactory) {
		case DB:
			db.setSource(eDaoFactory);
		case WS:
			ws.setSource(eDaoFactory);
		case XML:
			xml.setSource(eDaoFactory);
		}
	}

	@Override
	public Person getPersonByID(int id) {
		switch (eDaoFactory) {
		case DB:
			return db.getPersonByID(id);
		case WS:
			return ws.getPersonByID(id);
		case XML:
			return xml.getPersonByID(id);
		default:
			return null;
		}
	}

}
