package com.wmiiul.daofactory;

import org.apache.log4j.Logger;

import com.wmiiul.daofactory.dao.DaoFactory;
import com.wmiiul.daofactory.dao.EDaoFactory;
import com.wmiiul.daofactory.dao.datasources.XML;

public class Main {
	
	private static Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		DaoFactory daoFactory = new DaoFactory();
		daoFactory.setSource(EDaoFactory.DB);
		daoFactory.getSource().selectUserById(1);
		daoFactory.setSource(EDaoFactory.WS);
		daoFactory.getSource().selectUserById(2);
		daoFactory.setSource(EDaoFactory.XML);
		daoFactory.getSource().selectUserById(3);
		
		DaoFactory daoFactory2 = new DaoFactory();
		daoFactory2.setSource(EDaoFactory.XML);
    	
		logger.info(daoFactory.getSource());
		logger.info(daoFactory2.getSource());
	}
}
