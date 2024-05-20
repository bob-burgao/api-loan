package com.srm.demo.domain.usecases.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.dtos.PessoaDTO;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GetLimiteEmprestimoUseCaseImplTest {

    @InjectMocks
    private GetLimiteEmprestimoUseCaseImpl getLimiteEmprestimoUseCase;

    @Test
    void whenResultIsZero() {
        final List<EmprestimoDTO> emprestimos = List.of(EmprestimoDTO.builder()
        .valorEmprestimo(BigDecimal.valueOf(1000))
        .build());
        final PessoaDTO pessoa = PessoaDTO.builder()
        .emprestimos(emprestimos)
        .valorMaxEmprestimo(BigDecimal.valueOf(1000))
        .build();
        
        final BigDecimal result = getLimiteEmprestimoUseCase.exec(pessoa);

        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void whenResultIsNegative() {
        final List<EmprestimoDTO> emprestimos = List.of(EmprestimoDTO.builder()
        .valorEmprestimo(BigDecimal.valueOf(1000))
        .build());
        final PessoaDTO pessoa = PessoaDTO.builder()
        .emprestimos(emprestimos)
        .valorMaxEmprestimo(BigDecimal.valueOf(500))
        .build();
        
        final BigDecimal result = getLimiteEmprestimoUseCase.exec(pessoa);

        assertEquals(BigDecimal.valueOf(-500), result);
    }

    @Test
    void whenResultIsPositive() {
        final List<EmprestimoDTO> emprestimos = List.of(EmprestimoDTO.builder()
        .valorEmprestimo(BigDecimal.valueOf(500))
        .build());
        final PessoaDTO pessoa = PessoaDTO.builder()
        .emprestimos(emprestimos)
        .valorMaxEmprestimo(BigDecimal.valueOf(1000))
        .build();
        
        final BigDecimal result = getLimiteEmprestimoUseCase.exec(pessoa);

        assertEquals(BigDecimal.valueOf(500), result);
    }
}
