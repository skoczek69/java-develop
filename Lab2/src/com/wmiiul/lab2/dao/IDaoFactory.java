package com.wmiiul.lab2.dao;

import com.wmiiul.lab2.pojo.EDaoFactory;
import com.wmiiul.lab2.pojo.Person;

public interface IDaoFactory {

	void setSource(EDaoFactory source);

	Person getPersonByID(int id);

}
