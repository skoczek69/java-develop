package com.wmiiul.daofactory.dao;

import java.util.List;

import com.wmiiul.daofactory.pojo.User;

public interface IDaoFactory {

	List<User> selectAllUsers();

	User selectUserById(int user);

}
