package com.srm.demo.adapters.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.demo.adapters.controllers.mappers.CriarPessoaMapper;
import com.srm.demo.adapters.controllers.models.RequestCriarPessoa;
import com.srm.demo.adapters.controllers.models.ResponseCriarPessoa;
import com.srm.demo.domain.ports.inputs.CriarPessoaPortInput;


@RestController
@RequestMapping("pessoas")
public class PessoaController {

    private CriarPessoaPortInput criarPessoa;
    private CriarPessoaMapper criarPessoaMapper;

    @PostMapping
    public ResponseCriarPessoa criarPessoa(@RequestBody RequestCriarPessoa pessoa){
        return criarPessoaMapper.response(
            criarPessoa.executar(criarPessoaMapper.request(pessoa))
        );
    }

    @GetMapping
    public String teste(){
        return "funcinou";
    }
    
}
