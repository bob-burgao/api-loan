package com.srm.demo.domain.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.enums.StatusPagamento;
import com.srm.demo.domain.ports.inputs.SolicitarEmprestimoPortInput;
import com.srm.demo.domain.ports.outputs.CriarEmprestimoPortOutput;

@Component
public class SolicitarEmprestimoService implements SolicitarEmprestimoPortInput{

    @Autowired
    private CriarEmprestimoPortOutput criarEmprestimoPortOutput;

    @Override
    public EmprestimoDTO exec(String identificarPessoa, BigDecimal valor, int parcelas) {
        // TODO Auto-generated method stub
        final EmprestimoDTO emprestimoDTO = EmprestimoDTO.builder()
        .dataCriacao(LocalDateTime.now())
        .pessoaId(1L)
        .valorEmprestimo(valor)
        .numeroParcelas(parcelas)
        .statusPagamento(StatusPagamento.NO_PAGO)
        .build();
        return criarEmprestimoPortOutput.save(emprestimoDTO);
    }

}
