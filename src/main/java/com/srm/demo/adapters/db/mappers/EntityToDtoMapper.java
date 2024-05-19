package com.srm.demo.adapters.db.mappers;

import org.springframework.stereotype.Component;

import com.srm.demo.adapters.db.entities.Pessoa;
import com.srm.demo.domain.dtos.PessoaDTO;

@Component
public class EntityToDtoMapper {
    public PessoaDTO convert(Pessoa pessoa) {
        return PessoaDTO.builder()
        .nome(pessoa.getNome())
        .build();
    }
}
