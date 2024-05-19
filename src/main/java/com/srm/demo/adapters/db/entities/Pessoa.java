package com.srm.demo.adapters.db.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String identificador;

    private LocalDate dataNascimento;

    private TipoIdentificador tipoIdentificador;

    private BigDecimal valorMinMensal;

    private BigDecimal valorMaxEmprestimo;

    @OneToMany(mappedBy="pessoa")
    private Set<Emprestimo> emprestimos;
    
}
