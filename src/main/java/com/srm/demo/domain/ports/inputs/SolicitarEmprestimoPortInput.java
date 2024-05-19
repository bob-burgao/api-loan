package com.srm.demo.domain.ports.inputs;

import java.math.BigDecimal;

import com.srm.demo.domain.dtos.EmprestimoDTO;

public interface SolicitarEmprestimoPortInput {
    EmprestimoDTO exec(String identificarPessoa, BigDecimal valor, int parcelas);
}
