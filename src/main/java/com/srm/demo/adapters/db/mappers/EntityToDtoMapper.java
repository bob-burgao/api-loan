package com.srm.demo.adapters.db.mappers;

import java.util.List;

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
        if (pessoa == null) {
            return null;
        }
        return PessoaDTO.builder()
        .id(pessoa.getId())
        .nome(pessoa.getNome())
        .identificador(pessoa.getIdentificador())
        .dataNascimento(pessoa.getDataNascimento())
        .tipoIdentificador(TipoIdentificadorEnum.valueOf(pessoa.getTipoIdentificador()))
        .valorMinMensal(pessoa.getValorMinMensal())
        .valorMaxEmprestimo(pessoa.getValorMaxEmprestimo())
        .emprestimos(pessoa.getEmprestimos() == null || pessoa.getEmprestimos().isEmpty()  ? List.<EmprestimoDTO>of() : pessoa.getEmprestimos().stream().map(
            emprestimo -> convert(emprestimo)).toList())
        .build();
    }

    public EmprestimoDTO convert(Emprestimo emprestimo) {
        if (emprestimo == null) {
            return null;
        }
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
