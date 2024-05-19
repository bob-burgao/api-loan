package com.srm.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.exceptions.RequiredParamsNotFoundException;
import com.srm.demo.domain.ports.inputs.LocalizarPessoaPortInput;
import com.srm.demo.domain.ports.outputs.ManterPessoaPortOutput;

@Component
public class LocalizarPessoaService implements LocalizarPessoaPortInput{

     @Autowired
    private ManterPessoaPortOutput manterPessoa;

    @Override
    public PessoaDTO localizarByIdentificador(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            throw new RequiredParamsNotFoundException("identificador");
        }
        
        return manterPessoa.findByIdentificador(identificador);
    }

}
