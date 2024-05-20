package com.srm.demo.domain.usecases.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.enums.TipoIdentificadorEnum;
import com.srm.demo.domain.exceptions.InvalidIdentificadorException;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ValidarDocumentoUseCaseImplTest {

    @InjectMocks
    private ValidarDocumentoUseCaseImpl caseImpl;

    @Test
    void whenResultPfValid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.PF)
        .identificador("28242045089")
        .build(); 

        caseImpl.isValid(dto);
    }

    @Test
    void whenResultPfInvalid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.PF)
        .identificador("11111111111111")
        .build(); 

        InvalidIdentificadorException thrown = assertThrows(InvalidIdentificadorException.class,
            ()-> caseImpl.isValid(dto));

        assertEquals(thrown.getMessage(), "CPF inválido: " + dto.getIdentificador());
    }


    @Test
    void whenResultPjValid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.PJ)
        .identificador("41746129000120")
        .build(); 

        caseImpl.isValid(dto);
    }

    @Test
    void whenResultPjInvalid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.PJ)
        .identificador("11111111111111")
        .build(); 

        InvalidIdentificadorException thrown = assertThrows(InvalidIdentificadorException.class,
            ()-> caseImpl.isValid(dto));

        assertEquals(thrown.getMessage(), "CNPJ inválido: " + dto.getIdentificador());
    }
    

    @Test
    void whenResultEuValid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.EU)
        .identificador("12222228")
        .build(); 

        caseImpl.isValid(dto);
    }

    @Test
    void whenResultEuInvalid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.EU)
        .identificador("12222227")
        .build(); 

        InvalidIdentificadorException thrown = assertThrows(InvalidIdentificadorException.class,
            ()-> caseImpl.isValid(dto));

        assertEquals(thrown.getMessage(), "Estudante Universitário inválido: " + dto.getIdentificador());
    }
    

    @Test
    void whenResultApValid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.AP)
        .identificador("1234567890")
        .build(); 

        caseImpl.isValid(dto);
    }

    @Test
    void whenResultApInvalid() {     
        final PessoaDTO dto = PessoaDTO.builder()
        .tipoIdentificador(TipoIdentificadorEnum.AP)
        .identificador("1234567891")
        .build(); 

        InvalidIdentificadorException thrown = assertThrows(InvalidIdentificadorException.class,
            ()-> caseImpl.isValid(dto));

        assertEquals(thrown.getMessage(), "Aposentado inválido: " + dto.getIdentificador());
    }
}
