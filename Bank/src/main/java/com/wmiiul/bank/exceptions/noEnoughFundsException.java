package com.wmiiul.bank.exceptions;

public class noEnoughFundsException extends RuntimeException {

	private static final long serialVersionUID = 4679120165130547454L;

	@Override
	public String getMessage() {

		return "Brak wystarczajacych srodkow na koncie";

	}

}
