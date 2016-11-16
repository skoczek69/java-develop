package com.wmiiul.bank.pojo;

import org.apache.log4j.Logger;

public class Check extends Transaction {

	private static Logger logger = Logger.getLogger(Check.class.getName());

	public Check(TransactionEnum transactionType, String account, double amount, String description,
			int operationNumber) {
		super(transactionType, account, amount, description, operationNumber);
		logger.info(transactionInfo());
	}

	@Override
	public String transactionInfo() {
		return super.transactionInfo() + "Wykonano przelew na konto: " + super.getAccount() + ", na kwote: "
				+ String.format("%.2f", super.getAmount()) + " zl, Opis: " + super.getDescription();
	}

}
