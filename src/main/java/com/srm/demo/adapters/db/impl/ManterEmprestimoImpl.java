package com.srm.demo.adapters.db.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.adapters.db.entities.Emprestimo;
import com.srm.demo.adapters.db.mappers.DtoToEntityMapper;
import com.srm.demo.adapters.db.mappers.EntityToDtoMapper;
import com.srm.demo.adapters.db.repositories.EmprestimoRepository;
import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.enums.StatusPagamento;
import com.srm.demo.domain.ports.outputs.ManterEmprestimoPortOutput;

@Component
public class ManterEmprestimoImpl implements ManterEmprestimoPortOutput{

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private DtoToEntityMapper dtoToEntityMapper;
    @Autowired
    private EntityToDtoMapper entityToDtoMapper;

    @Override
    public EmprestimoDTO save(EmprestimoDTO dto) {
        return entityToDtoMapper.convert(
            emprestimoRepository.save(dtoToEntityMapper.newEmprestimo(dto))
        );
    }

    @Override
    public EmprestimoDTO alterarStatus(Long id, StatusPagamento status) {
        final Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        if (emprestimo.isPresent()) {
            emprestimo.get().setStatusPagamento(status.name());
            emprestimoRepository.save(emprestimo.get());
            return  entityToDtoMapper.convert(emprestimo.get());
        } 
        return null;
    }

}
