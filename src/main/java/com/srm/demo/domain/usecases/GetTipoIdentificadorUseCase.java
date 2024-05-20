package com.srm.demo.domain.usecases;

import com.srm.demo.domain.enums.TipoIdentificadorEnum;

public interface GetTipoIdentificadorUseCase {
    TipoIdentificadorEnum get(String identificador);
}
