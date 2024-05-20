package com.srm.demo.domain.usecases.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.usecases.GetLimiteEmprestimoUseCase;

@Component
public class GetLimiteEmprestimoUseCaseImpl implements GetLimiteEmprestimoUseCase{

    @Override
    public BigDecimal exec(PessoaDTO pessoa) {
        BigDecimal totalSolicitado = pessoa.getEmprestimos().stream()
            .map(EmprestimoDTO::getValorEmprestimo)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
            
        return pessoa.getValorMaxEmprestimo().subtract(totalSolicitado);
    }

}
