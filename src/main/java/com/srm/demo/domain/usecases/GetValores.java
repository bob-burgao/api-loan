package com.srm.demo.domain.usecases;

import com.srm.demo.domain.dtos.ValoresDTO;
import com.srm.demo.domain.enums.TipoIdentificadorEnum;

public interface GetValores {
    ValoresDTO get(TipoIdentificadorEnum tipoIdentificador);
}
