package com.srm.demo.domain.usecases.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.usecases.ValidarValorParcelaUseCase;

@Component
public class ValidarValorParcelaUseCaseImpl implements ValidarValorParcelaUseCase{

    @Override
    public boolean exec(BigDecimal valorMinMensal, BigDecimal valor, int parcelas) {
        final BigDecimal qtdParcelas = BigDecimal.valueOf(parcelas);
        final BigDecimal valorParcela = valor.divide(qtdParcelas, 4, RoundingMode.HALF_UP);
        if (valorParcela.compareTo(valorMinMensal) >= 0) {
            return true;
        }
        return false;
    }

}
