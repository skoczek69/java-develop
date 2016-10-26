package com.wmiiul.bank.pojo;

import org.apache.log4j.Logger;

public class Deposit extends Transaction{
	
	private static Logger logger = Logger.getLogger(Deposit.class.getName());
	
	public Deposit(String account, double amount, String description, int operationNumber) {
		super(account, amount, description, operationNumber);
		logger.info(super.transactionInfo()+"Otrzymano przelew z konta: "+account+", na kwote: "+amount);
	}
}
