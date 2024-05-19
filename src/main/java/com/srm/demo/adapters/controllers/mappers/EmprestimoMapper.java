package com.srm.demo.adapters.controllers.mappers;

import org.springframework.stereotype.Component;

import com.srm.demo.adapters.controllers.models.ResponseEmprestimo;
import com.srm.demo.domain.dtos.EmprestimoDTO;

@Component
public class EmprestimoMapper {

    public ResponseEmprestimo solicitarEmprestimo(EmprestimoDTO dto) {
        return ResponseEmprestimo.builder()
        .id(dto.getId())
        .valorEmprestimo(dto.getValorEmprestimo())
        .numeroParcelas(dto.getNumeroParcelas())
        .statusPagamento(dto.getStatusPagamento().name())
        .dataCriacao(dto.getDataCriacao())
        .build();
    }

}
