package com.wmiiul.exceptions;

public class wrongAccountNumberException extends RuntimeException {

	private static final long serialVersionUID = -4405883001112779331L;

	@Override
	public String getMessage() {
		
		return "Podany numer konta jest niepoprawny";
		
	}

}
