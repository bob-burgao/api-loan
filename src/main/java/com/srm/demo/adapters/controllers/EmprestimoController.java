package com.srm.demo.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.demo.adapters.controllers.models.RequestSolicitarEmprestimo;
import com.srm.demo.adapters.controllers.models.ResponseEmprestimo;

@RestController
@RequestMapping("emprestimos")
public class EmprestimoController {

    @PostMapping("/{identificador}")
    public ResponseEntity<ResponseEmprestimo> solicitarEmprestimo(
        @RequestBody RequestSolicitarEmprestimo emprestimo, @PathVariable String identificador){

        //TODO - Implementar Regra
        return new ResponseEntity<ResponseEmprestimo>(new ResponseEmprestimo(), HttpStatus.CREATED);
    }
}
