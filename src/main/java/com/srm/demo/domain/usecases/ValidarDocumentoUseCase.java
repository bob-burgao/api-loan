package com.srm.demo.domain.usecases;

import com.srm.demo.domain.dtos.PessoaDTO;

public interface ValidarDocumentoUseCase {

    void isValid(PessoaDTO pessoa);
}
