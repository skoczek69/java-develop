package com.wmiiul.bank.pojo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.wmiiul.bank.exceptions.BankAccountNotExistException;
import com.wmiiul.bank.exceptions.WrongSwiftCodeException;

public class Bank {

	private static Logger logger = Logger.getLogger(Bank.class.getName());

	private static final int CORRECT_SWIFT_LENTGH = 15;
	private static final int ACCOUNT_NUMBER_COUNTER_START_VALUE = 0;
	private static final int ACCOUNT_NUMBER_PREFIX_COUNTER_START_VALUE = 999;

	private String name;
	private String country;
	private String swift;
	private String accountNumberPrefix;
	private int accountNumberCounter = ACCOUNT_NUMBER_COUNTER_START_VALUE;
	private static int accountNumberPrefixCounter = ACCOUNT_NUMBER_PREFIX_COUNTER_START_VALUE;
	private ArrayList<Client> clients = new ArrayList<Client>();
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Bank(String name, String country, String swift) {
		if (swift.length() != CORRECT_SWIFT_LENTGH) {
			throw new WrongSwiftCodeException();
		}
		validSwiftCode(swift);
		this.name = name;
		this.country = country;
		this.swift = swift;
		accountNumberPrefixCounter++;
		this.accountNumberPrefix = String.valueOf(accountNumberPrefixCounter);
		logger.info("Utworzono bank o nazwie: " + name + ", zarejestrowany w kraju: " + country + ", o kodzie SWIFT: "
				+ swift);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getAccountNumberPrefix() {
		return accountNumberPrefix;
	}

	public void addAccount(String description, String firstName, String lastName, String pesel) {
		Client client = this.findClient(pesel);
		if (client == null) {
			client = new Client(firstName, lastName, pesel);
			clients.add(client);
		}
		accountNumberCounter++;
		Account account = new Account(makeAccountNumber(), description, name, client);
		accounts.add(account);
	}

	// Pierwsze 4 cyfry numeru banku stanowia prefiks banku
	private String makeAccountNumber() {
		String accountNumber = String.valueOf(accountNumberCounter);
		int length = accountNumber.length();
		return accountNumberPrefix + "00000000000".substring(0, 11 - length) + accountNumber;

	};

	public Client findClient(String pesel) {
		for (Client client : clients) {
			if (client.getPesel().equals(pesel)) {
				return client;
			}
		}
		return null;
	}

	public Account findAccount(String accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		throw new BankAccountNotExistException();
	}

	private void validSwiftCode(String swift) {
		try {
			for (char digit : swift.substring(0, 10).toCharArray()) {
				Integer.parseInt(String.valueOf(digit));
			}
		} catch (NumberFormatException e) {
			throw new WrongSwiftCodeException();
		}
	}
}
