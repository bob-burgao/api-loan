package com.srm.demo.domain.usecases.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.ValoresDTO;
import com.srm.demo.domain.enums.TipoIdentificadorEnum;
import com.srm.demo.domain.usecases.GetValores;

@Component
public class GetValoresImpl implements GetValores{

    @Override
    public ValoresDTO get(TipoIdentificadorEnum tipoIdentificador) {
        final ValoresDTO valores = ValoresDTO.builder().build();
        
        switch (tipoIdentificador) {
            case PF: {
                valores.setValorMaxEmprestimo(new BigDecimal(10000));
                valores.setValorMinMensal(new BigDecimal(300));
                break;
            }
            case PJ: {
                valores.setValorMaxEmprestimo(new BigDecimal(100000));
                valores.setValorMinMensal(new BigDecimal(1000));
                break;
            }
            case EU: {
                valores.setValorMaxEmprestimo(new BigDecimal(10000));
                valores.setValorMinMensal(new BigDecimal(100));
                break;
            }
            case AP: {
                valores.setValorMaxEmprestimo(new BigDecimal(25000));
                valores.setValorMinMensal(new BigDecimal(400));
                break;
            }
        }

        return valores;
    }
    
}
