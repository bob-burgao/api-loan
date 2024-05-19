package com.srm.demo.domain.services;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.ports.inputs.CriarPessoaPortInput;

@Component
public class CriarPessoaService implements CriarPessoaPortInput{

    @Override
    public PessoaDTO executar(PessoaDTO pessoa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executar'");
    }
    
}
