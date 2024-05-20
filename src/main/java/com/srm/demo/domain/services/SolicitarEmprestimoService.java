package com.srm.demo.domain.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.srm.demo.domain.dtos.EmprestimoDTO;
import com.srm.demo.domain.dtos.PessoaDTO;
import com.srm.demo.domain.enums.StatusPagamento;
import com.srm.demo.domain.exceptions.BusinessRoleException;
import com.srm.demo.domain.exceptions.DataNotFoundException;
import com.srm.demo.domain.exceptions.UnexpectedErrorException;
import com.srm.demo.domain.ports.inputs.SolicitarEmprestimoPortInput;
import com.srm.demo.domain.ports.outputs.ManterEmprestimoPortOutput;
import com.srm.demo.domain.ports.outputs.ManterPessoaPortOutput;
import com.srm.demo.domain.usecases.GetLimiteEmprestimoUseCase;
import com.srm.demo.domain.usecases.ValidarDocumentoUseCase;
import com.srm.demo.domain.usecases.ValidarValorParcelaUseCase;

@Component
public class SolicitarEmprestimoService implements SolicitarEmprestimoPortInput{

    private Logger logger = LogManager.getLogger(SolicitarEmprestimoService.class);

    @Autowired
    private ManterEmprestimoPortOutput manterEmprestimoPortOutput;
    @Autowired
    private ManterPessoaPortOutput manterPessoaPortOutput;
    @Autowired
    private ValidarDocumentoUseCase validarDocumentoUseCase;
    @Autowired
    private GetLimiteEmprestimoUseCase getLimiteEmprestimoUseCase;
    @Autowired
    private ValidarValorParcelaUseCase validarValorParcelaUseCase;

    @Override
    public EmprestimoDTO exec(String identificarPessoa, BigDecimal valor, int parcelas) {

        final PessoaDTO pessoa = manterPessoaPortOutput.findByIdentificador(identificarPessoa, StatusPagamento.NO_PAGO);

        if (pessoa == null) {
            throw new DataNotFoundException("Pessoa não localizada para o identificado: " + identificarPessoa);
        }

        validarDocumentoUseCase.isValid(pessoa);

        if (parcelas > 24) {
            throw new BusinessRoleException("A quantidade de parcelas não pode ser superior a 24");
        }

        final BigDecimal limiteRestante = getLimiteEmprestimoUseCase.exec(pessoa);
        if (limiteRestante.subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessRoleException("Valor limite excedido: " + limiteRestante);
        }

        if (!validarValorParcelaUseCase.exec(pessoa.getValorMinMensal(), valor, parcelas)) {
            throw new BusinessRoleException("Valor da parcela menor que o mínimo permitido: " + pessoa.getValorMinMensal());
        }

        final EmprestimoDTO emprestimoDTO = EmprestimoDTO.builder()
        .dataCriacao(LocalDateTime.now())
        .pessoaId(pessoa.getId())
        .valorEmprestimo(valor)
        .numeroParcelas(parcelas)
        .statusPagamento(StatusPagamento.NO_PAGO)
        .build();

        try {
            return manterEmprestimoPortOutput.save(emprestimoDTO);
        } catch (Exception e) {
            logger.error(e.getMessage());
             throw new UnexpectedErrorException("Erro inesperado ao salvar o emprestimo", e);
        }
    }

}
