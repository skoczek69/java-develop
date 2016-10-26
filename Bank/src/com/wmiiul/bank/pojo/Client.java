package com.wmiiul.bank.pojo;

import com.wmiiul.exceptions.wrongPeselNumberException;

public class Client {
	
	private String firstName;
	private String lastName;
	private String pesel;
	private int wireOutCounter = 0;
	
	public Client(String firstName, String lastName, String pesel) {
		if(pesel.length()!=11){
			throw new wrongPeselNumberException();
		}
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public int getWireOutValue() {
		wireOutCounter++;
		return wireOutCounter;
	}
	
}
