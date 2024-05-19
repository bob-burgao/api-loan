package com.srm.demo.adapters.controllers.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePessoa {
    private String nome;
    private String identificador;
    private LocalDate dataNascimento;
    private String tipoIdentificador;
    private BigDecimal valorMinMensal;
    private BigDecimal valorMaxEmprestimo;
    private List<ResponseEmprestimo> emprestimos;
}
