package com.wmiiul.bank.exceptions;

public class maximumBanksNumberException extends RuntimeException {

	private static final long serialVersionUID = -4405883001112779331L;

	@Override
	public String getMessage() {
		
		return "Osiagnieto maksymalna mozliwa liczbe bankow";
		
	}

}
