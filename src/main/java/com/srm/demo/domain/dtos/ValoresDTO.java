package com.srm.demo.domain.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValoresDTO {
    private BigDecimal valorMinMensal;
    private BigDecimal valorMaxEmprestimo;
}
