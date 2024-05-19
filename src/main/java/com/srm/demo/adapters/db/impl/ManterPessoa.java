package com.srm.demo.adapters.db.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.adapters.db.mappers.DtoToEntityMapper;
import com.srm.demo.adapters.db.mappers.EntityToDtoMapper;
import com.srm.demo.adapters.db.repositories.PessoaRepository;
import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.ports.outputs.ManterPessoaPortOutput;

@Component
public class ManterPessoa implements ManterPessoaPortOutput{

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private DtoToEntityMapper dtoToEntityMapper;
    @Autowired
    private EntityToDtoMapper entityToDtoMapper;

    @Override
    public PessoaDTO criar(PessoaDTO pessoa) {
        return entityToDtoMapper.convert(
            pessoaRepository.save(dtoToEntityMapper.newPessoa(pessoa))
        );
    }

    @Override
    public PessoaDTO findByIdentificador(String identificador) {
        return entityToDtoMapper.convert(
            pessoaRepository.findIdByIdentificador(identificador)
        );
    }
    
}
