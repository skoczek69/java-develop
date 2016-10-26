package com.wmiiul.bank.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.wmiiul.bank.pojo.Account;
import com.wmiiul.bank.pojo.Client;
import com.wmiiul.exceptions.wrongSwiftCodeException;

public class Bank {
	
	private static Logger logger = Logger.getLogger(Bank.class.getName());

	private String name;
	private String country;
	private String swift;
	private ArrayList<Client> clients = new ArrayList<Client>();
	private ArrayList<Account> accounts = new ArrayList<Account>();

	public Bank(String name, String country, String swift) {
		if (swift.length() != 8) {
			throw new wrongSwiftCodeException();
		}
		this.name = name;
		this.country = country;
		this.swift = swift;
		logger.info("Utworzono bank o nazwie: "+name+", zarejestrowany w kraju: "+country+", o kodzie SWIFT: "+swift);
	}

	public void addAccount(String accountNumber, String description, String firstName, String lastName, String pesel) {
		Client client = this.findClient(pesel);
		if(client == null){
			client = new Client(firstName, lastName, pesel);
			clients.add(client);
		}
		Account account = new Account(accountNumber, description, name, country, swift, client);
		accounts.add(account);
	}

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
		return null;
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

	public String getSwift() {
		return swift;
	}

}
