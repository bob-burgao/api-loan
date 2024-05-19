package com.srm.demo.domain.exceptions;

import java.util.Arrays;

public class RequiredParamsNotFoundException extends RuntimeException {

    public RequiredParamsNotFoundException(String... params){
        super("Parâmetros obrigatórios não informados: " + Arrays.toString(params));
    }

}
