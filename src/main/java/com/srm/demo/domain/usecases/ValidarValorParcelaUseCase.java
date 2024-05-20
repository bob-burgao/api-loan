package com.srm.demo.domain.usecases;

import java.math.BigDecimal;

public interface ValidarValorParcelaUseCase {
    boolean exec(BigDecimal valorMinMensal, BigDecimal valor, int parcelas);
}
