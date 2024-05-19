package com.srm.demo.adapters.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srm.demo.adapters.db.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
    Pessoa findIdByIdentificador(String identificador);
}
