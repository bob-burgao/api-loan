package com.srm.demo.domain.exceptions;

public class RequiredParamsNotFoundException extends RuntimeException {

    public RequiredParamsNotFoundException(String... params){
        super("Parâmetros obrigatórios não informados: " + params.toString());
    }

}
