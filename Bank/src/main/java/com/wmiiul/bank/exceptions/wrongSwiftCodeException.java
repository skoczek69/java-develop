package com.wmiiul.bank.exceptions;

public class wrongSwiftCodeException extends RuntimeException {

	private static final long serialVersionUID = 6181966704526296292L;

	@Override
	public String getMessage() {
		
		return "Podany kod SWIFT jest niepoprawny";
		
	}

}