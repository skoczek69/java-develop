package com.wmiiul.daofactory.dao;

import java.util.HashMap;
import java.util.List;

import com.wmiiul.daofactory.dao.datasources.DB;
import com.wmiiul.daofactory.dao.datasources.WS;
import com.wmiiul.daofactory.dao.datasources.XML;
import com.wmiiul.daofactory.pojo.User;

public class DaoFactory implements IDaoFactory {
	
	static HashMap<EDaoFactory, IDaoFactory> dataSources = new HashMap<EDaoFactory, IDaoFactory>();
	
	private IDaoFactory iDaoFactory = dataSources.get(EDaoFactory.XML);
	
	static{
		dataSources.put(EDaoFactory.DB, DB.getInstance());
		dataSources.put(EDaoFactory.WS, WS.getInstance());
		dataSources.put(EDaoFactory.XML, XML.getInstance());
	}	
	
	private static DaoFactory daoFactory = null;

	public static DaoFactory getInstance() {
		if (daoFactory == null) {
			daoFactory = new DaoFactory();
		}
		return daoFactory;
	}

	private DaoFactory() {
	}
	
	public void setSource(EDaoFactory dataSource) {
		iDaoFactory = dataSources.get(dataSource);
	}
	
	public List<User> selectAllUsers(){
		return iDaoFactory.selectAllUsers();
	}
	
	public User selectUserById(int user){
		return iDaoFactory.selectUserById(user);
	}
}
