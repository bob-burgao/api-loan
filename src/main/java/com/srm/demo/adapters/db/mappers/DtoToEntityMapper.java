package com.srm.demo.adapters.db.mappers;

import org.springframework.stereotype.Component;

import com.srm.demo.adapters.db.entities.Pessoa;
import com.srm.demo.domain.dtos.PessoaDTO;

@Component
public class DtoToEntityMapper {

    public Pessoa newPessoa(PessoaDTO dto) {
        return Pessoa.builder()
        .nome(dto.getNome())
        .identificador(dto.getIdentificador())
        .dataNascimento(dto.getDataNascimento())
        .tipoIdentificador(dto.getTipoIdentificador().toString())
        .valorMinMensal(dto.getValorMinMensal())
        .valorMaxEmprestimo(dto.getValorMaxEmprestimo())
        .build();
    }
}
