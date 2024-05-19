package com.srm.demo.adapters.controllers.mappers;

import org.springframework.stereotype.Component;

import com.srm.demo.adapters.controllers.models.RequestCriarPessoa;
import com.srm.demo.adapters.controllers.models.ResponseCriarPessoa;
import com.srm.demo.domain.dtos.PessoaDTO;

@Component
public class CriarPessoaMapper {

    public PessoaDTO request(RequestCriarPessoa pessoaRequest) {
        return PessoaDTO.builder()
        .nome(pessoaRequest.getNome())
        .identificador(pessoaRequest.getIdentificador())
        .dataNascimento(pessoaRequest.getDataNascimento())
        .build();
    }

    public ResponseCriarPessoa response(PessoaDTO pessoa) {
        return ResponseCriarPessoa.builder()
        .nome(pessoa.getNome())
        .identificador(pessoa.getIdentificador())
        .dataNascimento(pessoa.getDataNascimento())
        .tipoIdentificador(pessoa.getIdentificador())
        .valorMinMensal(pessoa.getValorMinMensal())
        .valorMaxEmprestimo(pessoa.getValorMaxEmprestimo())
        .build();
    }
    
}
