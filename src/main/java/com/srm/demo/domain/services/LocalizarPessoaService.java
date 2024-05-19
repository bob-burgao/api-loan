package com.srm.demo.domain.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.exceptions.RequiredParamsNotFoundException;
import com.srm.demo.domain.exceptions.UnexpectedErrorException;
import com.srm.demo.domain.ports.inputs.LocalizarPessoaPortInput;
import com.srm.demo.domain.ports.outputs.ManterPessoaPortOutput;

@Component
public class LocalizarPessoaService implements LocalizarPessoaPortInput{

    private Logger logger = LogManager.getLogger(LocalizarPessoaService.class);

     @Autowired
    private ManterPessoaPortOutput manterPessoa;

    @Override
    public PessoaDTO localizarByIdentificador(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            throw new RequiredParamsNotFoundException("identificador");
        }
        
        try {
            return manterPessoa.findByIdentificador(identificador);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new UnexpectedErrorException("Erro ao localizar pessoa por identificador", e);
        }
    }

}
