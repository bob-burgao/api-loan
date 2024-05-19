package com.srm.demo.domain.exceptions;

public class UnexpectedErrorException extends RuntimeException{

    public UnexpectedErrorException(String mensagem, Exception e) {
        super(mensagem, e);
    }
}
