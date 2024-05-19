package com.srm.demo.adapters.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.ports.inputs.CriarPessoaPortInput;


@RestController
@RequestMapping("pessoas")
public class PessoaController {

    private CriarPessoaPortInput criarPessoa;

    @PostMapping
    public PessoaDTO criarPessoa(@RequestBody PessoaDTO pessoa){
        return criarPessoa.executar(pessoa);
    }

    @GetMapping
    public String teste(){
        return "funcinou";
    }
    
}
