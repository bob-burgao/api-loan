package com.srm.demo.adapters.db.impl;

import org.springframework.stereotype.Component;

import com.srm.demo.adapters.db.mappers.DtoToEntityMapper;
import com.srm.demo.adapters.db.mappers.EntityToDtoMapper;
import com.srm.demo.adapters.db.repositories.PessoaRepository;
import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.ports.outputs.CriarPessoaPortOutput;

@Component
public class ManterPessoa implements CriarPessoaPortOutput{

    private PessoaRepository pessoaRepository;
    private DtoToEntityMapper dtoToEntityMapper;
    private EntityToDtoMapper entityToDtoMapper;

    @Override
    public PessoaDTO executar(PessoaDTO pessoa) {
        return entityToDtoMapper.convert(
            pessoaRepository.save(dtoToEntityMapper.newPessoa(pessoa))
        );
    }
    
}
