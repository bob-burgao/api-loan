package com.srm.demo.adapters.db.mappers;

import org.springframework.stereotype.Component;

import com.srm.demo.adapters.db.entities.Emprestimo;
import com.srm.demo.adapters.db.entities.Pessoa;
import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.enums.StatusPagamento;
import com.srm.demo.domain.enums.TipoIdentificadorEnum;

@Component
public class EntityToDtoMapper {
    public PessoaDTO convert(Pessoa pessoa) {
        return PessoaDTO.builder()
        .nome(pessoa.getNome())
        .identificador(pessoa.getIdentificador())
        .dataNascimento(pessoa.getDataNascimento())
        .tipoIdentificador(TipoIdentificadorEnum.valueOf(pessoa.getTipoIdentificador()))
        .valorMinMensal(pessoa.getValorMinMensal())
        .valorMaxEmprestimo(pessoa.getValorMaxEmprestimo())
        .build();
    }

    public EmprestimoDTO convert(Emprestimo emprestimo) {
        return EmprestimoDTO.builder()
        .id(emprestimo.getId())
        .pessoaId(emprestimo.getPessoa().getId())
        .valorEmprestimo(emprestimo.getValorEmprestimo())
        .numeroParcelas(emprestimo.getNumeroParcelas())
        .dataCriacao(emprestimo.getDataCriacao())
        .statusPagamento(StatusPagamento.valueOf(emprestimo.getStatusPagamento()))
        .build();
    }
}
