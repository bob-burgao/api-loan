package com.srm.demo.domain.usecases.impl;

import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.exceptions.InvalidIdentificadorException;
import com.srm.demo.domain.usecases.ValidarDocumentoUseCase;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

@Component
public class ValidarDocumentoUseCaseImpl implements ValidarDocumentoUseCase{

    private CPFValidator cpfValidator = new CPFValidator();
    private CNPJValidator cnpjValidator = new CNPJValidator();

    @Override
    public void isValid(PessoaDTO pessoa) {
        switch (pessoa.getTipoIdentificador()) {
            case PF:{
                try {
                    cpfValidator.assertValid(pessoa.getIdentificador());
                } catch (Exception e) {
                    throw new InvalidIdentificadorException("CPF inválido: " + pessoa.getIdentificador());
                }
                break;
            }

            case PJ:{
                try {
                    cnpjValidator.assertValid(pessoa.getIdentificador());
                } catch (Exception e) {
                    throw new InvalidIdentificadorException("CNPJ inválido: " + pessoa.getIdentificador());
                }
                break;
            }

            case EU:{
                if (!isEstudadeValid(pessoa.getIdentificador())) {
                    throw new InvalidIdentificadorException("Estudante Universitário inválido: " + pessoa.getIdentificador());
                }
                break;
            }

            case AP:{
                if (!isAposentadoValid(pessoa.getIdentificador())) {
                    throw new InvalidIdentificadorException("Aposentado inválido: " + pessoa.getIdentificador());
                }
                isAposentadoValid(pessoa.getIdentificador());
                break;
            }
        
            default: {
                throw new InvalidIdentificadorException();
            }
        }
    }

    private boolean isEstudadeValid(String identificador) {
        if (identificador.length() == 8) {
            final int firstNumber = identificador.charAt(0);
            final int lastNumber = identificador.charAt(7);
            if (firstNumber + lastNumber != 9) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean isAposentadoValid(String identificador) {
        if (identificador.length() == 10) {
            final String partId = identificador.substring(0, 8);
            final char lastNumber = identificador.charAt(9);
            if (partId.contains(String.valueOf(lastNumber))) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

}
