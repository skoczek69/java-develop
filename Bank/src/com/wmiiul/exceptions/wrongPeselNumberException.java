package com.wmiiul.exceptions;

public class wrongPeselNumberException extends RuntimeException {

	private static final long serialVersionUID = -4692049801031081698L;

	@Override
	public String getMessage() {
		
		return "Podany numer PESEL jest niepoprawny";
		
	}

}
