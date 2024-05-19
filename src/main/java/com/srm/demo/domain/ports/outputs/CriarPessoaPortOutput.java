package com.srm.demo.domain.ports.outputs;

import com.srm.demo.domain.dtos.PessoaDTO;

public interface CriarPessoaPortOutput {
    PessoaDTO executar(PessoaDTO pessoa);
}
