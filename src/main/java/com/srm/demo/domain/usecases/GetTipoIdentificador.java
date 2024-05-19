package com.srm.demo.domain.usecases;

import com.srm.demo.domain.enums.TipoIdentificadorEnum;

public interface GetTipoIdentificador {
    TipoIdentificadorEnum get(String identificador);
}
