package com.srm.demo.domain.usecases.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.srm.demo.domain.enums.TipoIdentificadorEnum;
import com.srm.demo.domain.exceptions.InvalidIdentificadorException;
import com.srm.demo.domain.exceptions.RequiredParamsNotFoundException;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class GetTipoIdentificadorUseCaseImplTest {

    @InjectMocks
    private GetTipoIdentificadorUseCaseImpl caseImpl;

    @Test
    void whenResultPF() {       
        final TipoIdentificadorEnum result = caseImpl.get("11122233344");

        assertEquals(TipoIdentificadorEnum.PF, result);
    }

    @Test
    void whenResultPJ() {       
        final TipoIdentificadorEnum result = caseImpl.get("11122233344455");

        assertEquals(TipoIdentificadorEnum.PJ, result);
    }

    @Test
    void whenResultEU() {       
        final TipoIdentificadorEnum result = caseImpl.get("12345678");

        assertEquals(TipoIdentificadorEnum.EU, result);
    }

    @Test
    void whenResultAP() {       
        final TipoIdentificadorEnum result = caseImpl.get("1234567890");

        assertEquals(TipoIdentificadorEnum.AP, result);
    }

    @Test
    void whenIdentificadorEmpty() {       
        assertThrows(RequiredParamsNotFoundException.class,
            ()->{
                caseImpl.get("");
            });
    }

    @Test
    void whenIdentificadorNull() {       
        assertThrows(RequiredParamsNotFoundException.class,
            ()->{
                caseImpl.get(null);
            });
    }

    @Test
    void whenIdentificadorInvalid() {       
        assertThrows(InvalidIdentificadorException.class,
            ()->{
                caseImpl.get("333");
            });
    }
}
