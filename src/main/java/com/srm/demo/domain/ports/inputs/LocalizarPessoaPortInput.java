package com.srm.demo.domain.ports.inputs;

import com.srm.demo.domain.dtos.PessoaDTO;

public interface LocalizarPessoaPortInput {
    PessoaDTO localizarByIdentificador(String identificador);
}
