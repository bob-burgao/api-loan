package com.srm.demo.adapters.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srm.demo.adapters.controllers.mappers.CriarPessoaMapper;
import com.srm.demo.adapters.controllers.models.RequestAtualizarPessoa;
import com.srm.demo.adapters.controllers.models.RequestCriarPessoa;
import com.srm.demo.adapters.controllers.models.ResponseCriarPessoa;
import com.srm.demo.adapters.controllers.models.ResponsePessoa;
import com.srm.demo.domain.ports.inputs.CriarPessoaPortInput;


@RestController
@RequestMapping("pessoas")
public class PessoaController {

    @Autowired
    private CriarPessoaPortInput criarPessoa;
    @Autowired
    private CriarPessoaMapper criarPessoaMapper;

    @PostMapping
    public ResponseEntity<ResponseCriarPessoa> criarPessoa(@RequestBody RequestCriarPessoa pessoa){
        final ResponseCriarPessoa response = criarPessoaMapper.response(
            criarPessoa.executar(criarPessoaMapper.request(pessoa))
        );
        return new ResponseEntity<ResponseCriarPessoa>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<ResponsePessoa> localizarByIdentificador(@PathVariable String identificador) {
        //TODO - Implementar regra
        return new ResponseEntity<ResponsePessoa>(new ResponsePessoa(), HttpStatus.OK);
    }

    @DeleteMapping("/{identificador}")
    public ResponseEntity<ResponsePessoa> removerByIdentificador(@PathVariable String identificador) {
        //TODO - Implementar regra
        return new ResponseEntity<ResponsePessoa>(new ResponsePessoa(), HttpStatus.OK);
    }

    @PutMapping("/{identificador}")
    public ResponseEntity<ResponsePessoa> atualizarByIdentificador(
        @PathVariable String identificador, 
        @RequestBody RequestAtualizarPessoa pessoa
        ) {
        //TODO - Implementar regra
        return new ResponseEntity<ResponsePessoa>(new ResponsePessoa(), HttpStatus.OK);
    }
    
}
