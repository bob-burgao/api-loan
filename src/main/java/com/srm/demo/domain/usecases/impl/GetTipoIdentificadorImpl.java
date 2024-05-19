package com.srm.demo.domain.usecases.impl;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.enums.TipoIdentificadorEnum;
import com.srm.demo.domain.exceptions.InvalidIdentificadorException;
import com.srm.demo.domain.exceptions.RequiredParamsNotFoundException;
import com.srm.demo.domain.usecases.GetTipoIdentificador;

@Component
public class GetTipoIdentificadorImpl implements GetTipoIdentificador{

    @Override
    public TipoIdentificadorEnum get(String identificador) {
        if (identificador == null) {
            throw new RequiredParamsNotFoundException("idenficador");
        }

        final int idenficadorSize = identificador.length();

        switch (idenficadorSize) {
            case 11: {
                return TipoIdentificadorEnum.PF;                
            }

            case 14: {
                return TipoIdentificadorEnum.PJ;                
            }

            case 8: {
                return TipoIdentificadorEnum.EU;                
            }

            case 10: {
                return TipoIdentificadorEnum.AP;                
            }
                
            default: {
                throw new InvalidIdentificadorException();
            }
        }
    }

}
