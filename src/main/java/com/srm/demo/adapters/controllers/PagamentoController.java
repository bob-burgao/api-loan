package com.srm.demo.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.demo.adapters.controllers.mappers.EmprestimoMapper;
import com.srm.demo.adapters.controllers.models.ResponseEmprestimo;
import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.ports.inputs.PagarEmprestimoPortInput;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    @Autowired
    private PagarEmprestimoPortInput emprestimoPortInput;
    @Autowired
    private EmprestimoMapper emprestimoMapper;

    @PostMapping("/{idEmprestimo}")
    public ResponseEntity<ResponseEmprestimo> pagarEmprestimo(@PathVariable Long idEmprestimo){
        final EmprestimoDTO emprestimoDTO = emprestimoPortInput.exec(idEmprestimo);
        return new ResponseEntity<ResponseEmprestimo>(emprestimoMapper.solicitarEmprestimo(emprestimoDTO), HttpStatus.OK);
    }

}
