package com.srm.demo.adapters.db.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.adapters.db.mappers.DtoToEntityMapper;
import com.srm.demo.adapters.db.mappers.EntityToDtoMapper;
import com.srm.demo.adapters.db.repositories.EmprestimoRepository;
import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.ports.outputs.ManterEmprestimoPortOutput;

@Component
public class RegistrarEmprestimoImpl implements ManterEmprestimoPortOutput{

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

}
