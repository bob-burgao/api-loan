package com.srm.demo.domain.usecases;

import java.math.BigDecimal;

import com.srm.demo.domain.dtos.PessoaDTO;

public interface GetLimiteEmprestimoUseCase {
    BigDecimal exec(PessoaDTO pessoa);
}
