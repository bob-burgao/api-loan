package com.srm.demo.domain.ports.outputs;

import com.srm.demo.domain.dtos.PessoaDTO;

public interface ManterPessoaPortOutput {
    PessoaDTO criar(PessoaDTO pessoa);
    PessoaDTO findByIdentificador(String identificador);
}
