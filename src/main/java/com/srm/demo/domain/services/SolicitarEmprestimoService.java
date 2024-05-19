package com.srm.demo.domain.services;

import java.math.BigDecimal;

import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.ports.inputs.SolicitarEmprestimoPortInput;

public class SolicitarEmprestimoService implements SolicitarEmprestimoPortInput{

    @Override
    public EmprestimoDTO exec(String identificarPessoa, BigDecimal valor, int parcelas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exec'");
    }

}
