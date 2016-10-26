package com.wmiiul.bank.pojo;

import org.apache.log4j.Logger;

public class Wipeout extends Transaction{
	
	private String country;
	private String swift;
	
	private static Logger logger = Logger.getLogger(Wipeout.class.getName());

	public Wipeout(String account, double amount, String description, int operationNumber, String country, String swift) {
		super(account, amount, description, operationNumber);
		this.country = country;
		this.swift = swift;
		logger.info(super.transactionInfo()+"Wykonano przelew na konto: "+account+", na kwote: "+amount+", na konto o kodzie SWIFT: "+swift);
	}
	
}
