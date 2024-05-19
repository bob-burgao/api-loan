package com.srm.demo.domain.services;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.exceptions.RequiredParamsNotFoundException;
import com.srm.demo.domain.ports.inputs.LocalizarPessoaPortInput;

@Component
public class LocalizarPessoaService implements LocalizarPessoaPortInput{

    @Override
    public PessoaDTO localizarByIdentificador(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            throw new RequiredParamsNotFoundException("identificador");
        }
        throw new UnsupportedOperationException("Unimplemented method 'localizarByIdentificador'");
    }

}
