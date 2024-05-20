package com.srm.demo.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.dtos.ValoresDTO;
import com.srm.demo.domain.enums.TipoIdentificadorEnum;
import com.srm.demo.domain.exceptions.UnexpectedErrorException;
import com.srm.demo.domain.ports.outputs.ManterPessoaPortOutput;
import com.srm.demo.domain.usecases.GetTipoIdentificadorUseCase;
import com.srm.demo.domain.usecases.GetValoresUseCase;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CriarPessoaServiceTest {

    @InjectMocks
    private CriarPessoaService service;

    @Mock
    private ManterPessoaPortOutput manterPessoa;

    @Mock
    private GetTipoIdentificadorUseCase getTipoIdentificador;
    
    @Mock
    private GetValoresUseCase getValores;


    @Test
    void whenCreate() {
        final PessoaDTO dto = PessoaDTO.builder()
        .nome("nome")
        .dataNascimento(LocalDate.now())
        .identificador("41746129000120")
        .build();
        final ValoresDTO valores = ValoresDTO.builder()
        .valorMaxEmprestimo(BigDecimal.valueOf(10000))
        .valorMinMensal(BigDecimal.valueOf(200))
        .build();
        when(manterPessoa.criar(dto)).thenReturn(dto);
        when(getTipoIdentificador.get(dto.getIdentificador())).thenReturn(TipoIdentificadorEnum.PJ);
        when(getValores.get(any())).thenReturn(valores);

        final PessoaDTO result = service.executar(dto);

        assertEquals("nome", result.getNome());
        assertEquals(TipoIdentificadorEnum.PJ, result.getTipoIdentificador());
        assertEquals(BigDecimal.valueOf(10000), result.getValorMaxEmprestimo());
        assertEquals(BigDecimal.valueOf(200), result.getValorMinMensal());

    }

    @Test
    void whenError() {
        final PessoaDTO dto = PessoaDTO.builder()
        .nome("nome")
        .dataNascimento(LocalDate.now())
        .identificador("41746129000120")
        .build();
        final ValoresDTO valores = ValoresDTO.builder()
        .valorMaxEmprestimo(BigDecimal.valueOf(10000))
        .valorMinMensal(BigDecimal.valueOf(200))
        .build();
        when(manterPessoa.criar(dto)).thenThrow(NullPointerException.class);
        when(getTipoIdentificador.get(dto.getIdentificador())).thenReturn(TipoIdentificadorEnum.PJ);
        when(getValores.get(any())).thenReturn(valores);

        UnexpectedErrorException thrown = assertThrows(UnexpectedErrorException.class,
            ()-> service.executar(dto));

        assertEquals(thrown.getMessage(), "Erro ao registrar nova pessoa");

    }
}
