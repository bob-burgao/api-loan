package com.srm.demo.adapters.controllers.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestSolicitarEmprestimo {
    private BigDecimal valor;
    private Integer parcelas;
}
