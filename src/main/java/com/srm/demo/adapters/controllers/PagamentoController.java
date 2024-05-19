package com.srm.demo.adapters.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.demo.adapters.controllers.models.ResponseEmprestimo;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    @PostMapping("/{idEmprestimo}")
    public ResponseEntity<ResponseEmprestimo> pagarEmprestimo(@PathVariable String identificador){

        //TODO - Implementar Regra
        return new ResponseEntity<ResponseEmprestimo>(new ResponseEmprestimo(), HttpStatus.OK);
    }

}
