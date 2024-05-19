package com.srm.demo.adapters.controllers.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCriarPessoa {
    private String nome;
    private String identificador;
    private LocalDate dataNascimento;
}
