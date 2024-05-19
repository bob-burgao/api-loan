package com.srm.demo.domain.exceptions;

public class InvalidIdentificadorException extends RuntimeException {

    public InvalidIdentificadorException() {
        super("Identificador inválido");
    }

    public InvalidIdentificadorException(String message) {
        super(message);
    }

}
