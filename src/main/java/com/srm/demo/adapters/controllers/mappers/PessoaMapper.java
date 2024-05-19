package com.srm.demo.adapters.controllers.mappers;

import org.springframework.stereotype.Component;

import com.srm.demo.adapters.controllers.models.RequestCriarPessoa;
import com.srm.demo.adapters.controllers.models.ResponseCriarPessoa;
import com.srm.demo.adapters.controllers.models.ResponseEmprestimo;
import com.srm.demo.adapters.controllers.models.ResponsePessoa;
import com.srm.demo.domain.dtos.PessoaDTO;

@Component
public class PessoaMapper {

    public PessoaDTO request(RequestCriarPessoa pessoaRequest) {
        return PessoaDTO.builder()
        .nome(pessoaRequest.getNome())
        .identificador(pessoaRequest.getIdentificador())
        .dataNascimento(pessoaRequest.getDataNascimento())
        .build();
    }

    public ResponseCriarPessoa responseCriar(PessoaDTO pessoa) {
        return ResponseCriarPessoa.builder()
        .nome(pessoa.getNome())
        .identificador(pessoa.getIdentificador())
        .dataNascimento(pessoa.getDataNascimento())
        .tipoIdentificador(pessoa.getTipoIdentificador().name())
        .valorMinMensal(pessoa.getValorMinMensal())
        .valorMaxEmprestimo(pessoa.getValorMaxEmprestimo())
        .build();
    }

    public ResponsePessoa responsePessoa(PessoaDTO pessoa) {
        return (ResponsePessoa) ResponsePessoa.builder()
        .nome(pessoa.getNome())
        .identificador(pessoa.getIdentificador())
        .dataNascimento(pessoa.getDataNascimento())
        .tipoIdentificador(pessoa.getTipoIdentificador().name())
        .valorMinMensal(pessoa.getValorMinMensal())
        .valorMaxEmprestimo(pessoa.getValorMaxEmprestimo())
        .emprestimos(pessoa.getEmprestimos()
            .stream().map(
                empretimo -> ResponseEmprestimo.builder()
                .id(empretimo.getId())
                .valorEmprestimo(empretimo.getValorEmprestimo())
                .numeroParcelas(empretimo.getNumeroParcelas())
                .statusPagamento(empretimo.getStatusPagamento().name())
                .dataCriacao(empretimo.getDataCriacao())
                .build()
            ).toList())
        .build();
    }
    
}
