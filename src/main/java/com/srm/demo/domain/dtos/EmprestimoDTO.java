package com.srm.demo.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.srm.demo.domain.enums.StatusPagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {
    private Long id;
    private Long pessoaId;
    private BigDecimal valorEmprestimo;
    private Integer numeroParcelas;
    private StatusPagamento statusPagamento;
    private LocalDateTime dataCriacao;
}
