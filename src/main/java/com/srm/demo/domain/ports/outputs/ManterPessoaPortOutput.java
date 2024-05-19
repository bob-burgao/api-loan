package com.srm.demo.domain.ports.outputs;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.enums.StatusPagamento;

public interface ManterPessoaPortOutput {
    PessoaDTO criar(PessoaDTO pessoa);
    PessoaDTO findByIdentificador(String identificador);
    PessoaDTO findByIdentificador(String identificador, StatusPagamento statusPagamento);
}
