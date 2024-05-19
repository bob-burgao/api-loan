package com.srm.demo.domain.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.srm.demo.domain.enums.TipoIdentificadorEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private String nome;
    private String identificador;
    private LocalDate dataNascimento;
    private TipoIdentificadorEnum tipoIdentificador;
    private BigDecimal valorMinMensal;
    private BigDecimal valorMaxEmprestimo;
    private List<EmprestimoDTO> emprestimos;
}
