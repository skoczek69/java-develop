package com.wmiiul.bank.pojo;

import org.apache.log4j.Logger;

public class Deposit extends Transaction {

	private static Logger logger = Logger.getLogger(Deposit.class.getName());

	public Deposit(TransactionEnum transactionType, String account, double amount, String description,
			int operationNumber) {
		super(transactionType, account, amount, description, operationNumber);
		logger.info(transactionInfo());
	}

	@Override
	public String transactionInfo() {
		return super.transactionInfo() + "Otrzymano przelew z konta: " + super.getAccount() + ", na kwote: "
				+ String.format("%.2f", super.getAmount()) + " zl, Opis: " + super.getDescription();
	}
}
