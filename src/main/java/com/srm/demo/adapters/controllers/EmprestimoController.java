package com.srm.demo.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.demo.adapters.controllers.mappers.EmprestimoMapper;
import com.srm.demo.adapters.controllers.models.RequestSolicitarEmprestimo;
import com.srm.demo.adapters.controllers.models.ResponseEmprestimo;
import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.ports.inputs.SolicitarEmprestimoPortInput;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @Autowired
    private SolicitarEmprestimoPortInput emprestimoPortInput;
    @Autowired
    private EmprestimoMapper emprestimoMapper;

    @PostMapping("/{identificador}")
    public ResponseEntity<ResponseEmprestimo> solicitarEmprestimo(
        @RequestBody RequestSolicitarEmprestimo emprestimo, @PathVariable String identificador){
        final EmprestimoDTO emprestimoDTO = emprestimoPortInput.exec(identificador, emprestimo.getValor(), emprestimo.getParcelas());
        return new ResponseEntity<ResponseEmprestimo>(emprestimoMapper.solicitarEmprestimo(emprestimoDTO), HttpStatus.CREATED);
    }
}
