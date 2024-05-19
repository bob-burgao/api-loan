package com.srm.demo.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {
    private BigDecimal valorEmprestimo;
    private Integer numeroParcelas;
    private String statusPagamento;
    private LocalDateTime dataCriacao;
}
