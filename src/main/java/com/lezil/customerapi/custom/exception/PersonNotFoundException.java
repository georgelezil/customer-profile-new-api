package com.lezil.customerapi.custom.exception;

public class PersonNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
    private String errorMessage;
  
    public String getErrorMessage() {
        return errorMessage;
    }
    public PersonNotFoundException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public PersonNotFoundException() {
        super();
    }
}
