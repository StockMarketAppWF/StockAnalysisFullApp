package com.wellsfargo.sectorservice.exceptionHandler;
public class MissingParamsException extends RuntimeException {
    public MissingParamsException(String e) {
        super(MissingParamsException.generateMessage(e));
    }

    private static String generateMessage(String exception) {
        return  "Error: " + exception;
    }
}