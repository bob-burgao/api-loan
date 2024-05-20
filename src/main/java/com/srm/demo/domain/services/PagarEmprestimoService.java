package com.srm.demo.domain.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.enums.StatusPagamento;
import com.srm.demo.domain.exceptions.DataNotFoundException;
import com.srm.demo.domain.exceptions.UnexpectedErrorException;
import com.srm.demo.domain.ports.inputs.PagarEmprestimoPortInput;
import com.srm.demo.domain.ports.outputs.ManterEmprestimoPortOutput;

@Component
public class PagarEmprestimoService implements PagarEmprestimoPortInput{

    private Logger logger = LogManager.getLogger(PagarEmprestimoService.class);

    @Autowired
    private ManterEmprestimoPortOutput manterEmprestimoPortOutput;

    @Override
    public EmprestimoDTO exec(Long id) {
        EmprestimoDTO emprestimo = null;
        
        try {
            emprestimo =  manterEmprestimoPortOutput.alterarStatus(id, StatusPagamento.PAGO);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new UnexpectedErrorException("Erro inesperado ao pagar emprestimo", e);
        }

        if (emprestimo == null) {
            throw new DataNotFoundException("Emprestimo não encontrado: " + id);
        }
        return emprestimo;
    }

}
