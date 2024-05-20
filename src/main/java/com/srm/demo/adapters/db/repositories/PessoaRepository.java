package com.srm.demo.adapters.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.srm.demo.adapters.db.entities.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
    Pessoa findIdByIdentificador(String identificador);

    @Query("SELECT p FROM Pessoa p LEFT JOIN p.emprestimos e ON p.id = e.pessoa.id AND e.statusPagamento=:status WHERE p.identificador = :identificador")
    Pessoa findOneByIdentificadorAndEmpretimoStatus(String identificador, String status);
}
