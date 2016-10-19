package com.wmiiul.lab2;

import org.apache.log4j.Logger;

import com.wmiiul.lab2.dao.DaoFactory;
import com.wmiiul.lab2.pojo.EDaoFactory;
import com.wmiiul.lab2.pojo.Person;

public class Main {

	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		DaoFactory df = DaoFactory.getInstance();
		df.setSource(EDaoFactory.DB);
		logger.trace(df.getPersonByID(10).toString());
		df.setSource(EDaoFactory.WS);
		logger.trace(df.getPersonByID(10).toString());
		df.setSource(EDaoFactory.XML);
		logger.trace(df.getPersonByID(10).toString());
		logger.info("Number of persons : "+Person.getCount());
	}
}
