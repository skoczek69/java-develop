package com.wmiiul.exceptions;

public class wrongOperationTypeException extends RuntimeException {

	private static final long serialVersionUID = -2342483251508291295L;

	@Override
	public String getMessage() {
		
		return "Nie istnieje operacja o podanym identyfikatorze";
		
	}

}
