package com.srm.demo.domain.usecases.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ValidarValorParcelaUseCaseImplTest {

    @InjectMocks
    private ValidarValorParcelaUseCaseImpl caseImpl;

    @Test
    void whenParcelaAcima() {
        final boolean result = caseImpl.exec(BigDecimal.valueOf(100), BigDecimal.valueOf(1000), 2);
        assertEquals(true, result);
    }

    @Test
    void whenParcelaIgual() {
        final boolean result = caseImpl.exec(BigDecimal.valueOf(100), BigDecimal.valueOf(1000), 10);
        assertEquals(true, result);
    }

    @Test
    void whenParcelaAbaixo() {
        final boolean result = caseImpl.exec(BigDecimal.valueOf(100), BigDecimal.valueOf(1000), 11);
        assertEquals(false, result);

    }
}
