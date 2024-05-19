package com.srm.demo.domain.ports.outputs;

import com.srm.demo.domain.dtos.EmprestimoDTO;

public interface CriarEmprestimoPortOutput {

    EmprestimoDTO save(EmprestimoDTO dto);
    
}
