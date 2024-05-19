package com.srm.demo.domain.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.dtos.ValoresDTO;
import com.srm.demo.domain.exceptions.UnexpectedErrorException;
import com.srm.demo.domain.ports.inputs.CriarPessoaPortInput;
import com.srm.demo.domain.ports.outputs.ManterPessoaPortOutput;
import com.srm.demo.domain.usecases.GetTipoIdentificador;
import com.srm.demo.domain.usecases.GetValores;

@Component
public class CriarPessoaService implements CriarPessoaPortInput{

    @Autowired
    private GetTipoIdentificador getTipoIdentificador;
    @Autowired
    private GetValores getValores;
    @Autowired
    private ManterPessoaPortOutput manterPessoa;

    private Logger logger = LogManager.getLogger(CriarPessoaService.class);

    @Override
    public PessoaDTO executar(PessoaDTO pessoa) {

        pessoa.setTipoIdentificador(getTipoIdentificador.get(pessoa.getIdentificador()));

        final ValoresDTO valores = getValores.get(pessoa.getTipoIdentificador());
        pessoa.setValorMaxEmprestimo(valores.getValorMaxEmprestimo());
        pessoa.setValorMinMensal(valores.getValorMinMensal());


        try {
            return manterPessoa.criar(pessoa);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new UnexpectedErrorException("Erro ao registrar nova pessoa", e);
        }
    }
    
    
}
