	package com.wmiiul.bank.pojo;

import org.apache.log4j.Logger;

public class Check extends Transaction{
	
	private static Logger logger = Logger.getLogger(Check.class.getName());
	
	public Check(String account, double amount, String description, int operationNumber) {
		super(account, amount, description, operationNumber);
		logger.info(super.transactionInfo()+"Wykonano przelew na konto: "+account+", na kwote: "+amount);
	}

}
