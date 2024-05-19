package com.srm.demo.domain.services;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.ports.inputs.CriarPessoaPortInput;
import com.srm.demo.domain.usecases.GetTipoIdentificador;

@Component
public class CriarPessoaService implements CriarPessoaPortInput{

    private GetTipoIdentificador getTipoIdentificador;

    @Override
    public PessoaDTO executar(PessoaDTO pessoa) {

        pessoa.setTipoIdentificador(getTipoIdentificador.get(pessoa.getIdentificador()));


        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executar'");
    }
    
    
}
