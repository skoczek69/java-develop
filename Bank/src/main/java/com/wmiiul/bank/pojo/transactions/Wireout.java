package com.wmiiul.bank.pojo.transactions;

import org.apache.log4j.Logger;

public class Wireout extends Transaction {

	private String country;
	private String swift;

	private static Logger logger = Logger.getLogger(Wireout.class.getName());

	public Wireout(TransactionEnum transactionType, String account, double amount, String description,
			int operationNumber, String country, String swift) {
		super(transactionType, account, amount, description, operationNumber);
		this.country = country;
		this.swift = swift;
		logger.info(transactionInfo());
	}

	@Override
	public String transactionInfo() {
		return super.transactionInfo() + "Wykonano przelew na konto: " + super.getAccount() + ", o kodzie SWIFT: "
				+ swift + ", na kwote: " + String.format("%.2f", super.getAmount()) + " zl, Opis: "
				+ super.getDescription();
	}

}