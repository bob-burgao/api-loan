package com.srm.demo.domain.ports.inputs;

import com.srm.demo.domain.dtos.EmprestimoDTO;

public interface PagarEmprestimoPortInput {
    EmprestimoDTO exec(Long id);
}
