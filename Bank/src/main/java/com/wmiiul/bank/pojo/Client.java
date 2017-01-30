package com.wmiiul.bank.pojo;

import com.wmiiul.bank.exceptions.WrongPeselNumberException;

public class Client {

	private static final int CORRECT_PESEL_LENTGH = 11;
	private static final int WIRE_OUT_COUNTER_START_VALUE = 0;
	
	private String firstName;
	private String lastName;
	private String pesel;
	private int wireOutCounter = WIRE_OUT_COUNTER_START_VALUE;

	public Client(String firstName, String lastName, String pesel) {
		if (pesel.length() != CORRECT_PESEL_LENTGH || validPesel(pesel) == false) {
			throw new WrongPeselNumberException();
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

	public boolean validPesel(String pesel) {
		int i = 0;
		int sum = 0;
		try {
			for (char digit : pesel.substring(0, 10).toCharArray()) {
				int[] multipliers = { 1, 3, 7, 9 };
				sum += Integer.parseInt(String.valueOf(digit)) * multipliers[i % 4];
				i++;
			}
		} catch (NumberFormatException e) {
			throw new WrongPeselNumberException();
		}
		if (!((10 - (sum % 10)) == Integer.parseInt(String.valueOf(pesel.charAt(10))))) {
			return false;
		}
		return true;
	}

	public int getWireOutValue() {
		wireOutCounter++;
		return wireOutCounter;
	}

}
