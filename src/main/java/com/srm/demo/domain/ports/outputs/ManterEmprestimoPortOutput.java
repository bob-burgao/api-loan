package com.srm.demo.domain.ports.outputs;

import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.enums.StatusPagamento;

public interface ManterEmprestimoPortOutput {

    EmprestimoDTO save(EmprestimoDTO dto);
    
    EmprestimoDTO alterarStatus(Long id, StatusPagamento status);
}
