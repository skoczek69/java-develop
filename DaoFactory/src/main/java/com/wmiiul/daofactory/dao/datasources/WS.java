package com.wmiiul.daofactory.dao.datasources;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;

import com.wmiiul.daofactory.dao.IDaoFactory;
import com.wmiiul.daofactory.pojo.User;

public class WS implements IDaoFactory {

	private static Logger logger = Logger.getLogger(WS.class.getName());

	User mockedUser = EasyMock.createMock(User.class);

	private static WS ws = null;

	public static WS getInstance() {
		if (ws == null) {
			ws = new WS();
		}
		return ws;
	}

	private WS() {
	}

	public List<User> selectAllUsers() {
		List<User> mockedUsersList = EasyMock.createMock(ArrayList.class);
		EasyMock.expect(mockedUsersList.size()).andReturn(1);
		EasyMock.expect(mockedUsersList.get(0)).andReturn(mockedUser);
		EasyMock.replay(mockedUsersList);
		return mockedUsersList;
	}

	public User selectUserById(int id) {
		EasyMock.expect(mockedUser.getId()).andReturn(id);
		EasyMock.expect(mockedUser.getName()).andReturn("Jacek");
		EasyMock.expect(mockedUser.getAge()).andReturn(22);
		EasyMock.replay(mockedUser);
		logger.trace("User [id=" + mockedUser.getId() + ", name=" + mockedUser.getName() + ", age=" + mockedUser.getAge() + "]");
		return mockedUser;
	}

}
