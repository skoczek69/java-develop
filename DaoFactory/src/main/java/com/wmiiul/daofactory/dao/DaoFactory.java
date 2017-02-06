package com.wmiiul.daofactory.dao;

import java.util.HashMap;
import java.util.List;

import com.wmiiul.daofactory.dao.datasources.DB;
import com.wmiiul.daofactory.dao.datasources.WS;
import com.wmiiul.daofactory.dao.datasources.XML;
import com.wmiiul.daofactory.pojo.User;

public class DaoFactory{
	
	static HashMap<EDaoFactory, IDaoFactory> dataSources = new HashMap<EDaoFactory, IDaoFactory>();
	
	private IDaoFactory iDaoFactory;

	public  DaoFactory() {
		dataSources.put(EDaoFactory.DB, DB.getInstance());
		dataSources.put(EDaoFactory.WS, WS.getInstance());
		dataSources.put(EDaoFactory.XML, XML.getInstance());
	}
	
	public void setSource(EDaoFactory dataSource) {
		iDaoFactory = dataSources.get(dataSource);
	}
	
	public IDaoFactory getSource() {
		return iDaoFactory;
	}
}
