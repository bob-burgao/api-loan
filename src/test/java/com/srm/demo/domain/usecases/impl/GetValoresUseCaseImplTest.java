package com.srm.demo.domain.usecases.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.srm.demo.domain.dtos.ValoresDTO;
import com.srm.demo.domain.enums.TipoIdentificadorEnum;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GetValoresUseCaseImplTest {

    @InjectMocks
    private GetValoresUseCaseImpl caseImpl;

    @Test
    void whenResultPF() {       
        final ValoresDTO result = caseImpl.get(TipoIdentificadorEnum.PF);

        assertEquals(new BigDecimal(10000), result.getValorMaxEmprestimo());
        assertEquals(new BigDecimal(300), result.getValorMinMensal());
    }

    @Test
    void whenResultPJ() {       
        final ValoresDTO result = caseImpl.get(TipoIdentificadorEnum.PJ);

        assertEquals(new BigDecimal(100000), result.getValorMaxEmprestimo());
        assertEquals(new BigDecimal(1000), result.getValorMinMensal());
    }

    @Test
    void whenResultEU() {       
        final ValoresDTO result = caseImpl.get(TipoIdentificadorEnum.EU);

        assertEquals(new BigDecimal(10000), result.getValorMaxEmprestimo());
        assertEquals(new BigDecimal(100), result.getValorMinMensal());
    }

    @Test
    void whenResultAP() {       
        final ValoresDTO result = caseImpl.get(TipoIdentificadorEnum.AP);

        assertEquals(new BigDecimal(25000), result.getValorMaxEmprestimo());
        assertEquals(new BigDecimal(400), result.getValorMinMensal());
    }

}
