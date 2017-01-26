package com.wmiiul.daofactory;

import com.wmiiul.daofactory.dao.DaoFactory;
import com.wmiiul.daofactory.dao.EDaoFactory;

public class Main {

	public static void main(String[] args) {
		DaoFactory daoFactory = DaoFactory.getInstance();
		daoFactory.setSource(EDaoFactory.DB);
		daoFactory.selectUserById(1).toString();
		daoFactory.setSource(EDaoFactory.WS);
		daoFactory.selectUserById(2).toString();
		daoFactory.setSource(EDaoFactory.XML);
		daoFactory.selectUserById(3).toString();
	}
}
