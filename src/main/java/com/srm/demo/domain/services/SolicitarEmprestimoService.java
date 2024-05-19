package com.srm.demo.domain.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
import com.srm.demo.domain.usecases.ValidarDocumentoUseCase;

@Component
public class SolicitarEmprestimoService implements SolicitarEmprestimoPortInput{

    private Logger logger = LogManager.getLogger(SolicitarEmprestimoService.class);

    @Autowired
    private ManterEmprestimoPortOutput manterEmprestimoPortOutput;
    @Autowired
    private ManterPessoaPortOutput manterPessoaPortOutput;
    @Autowired
    private ValidarDocumentoUseCase validarDocumentoUseCase;

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

        final BigDecimal limiteRestante = getLimiteEmprestimo(pessoa);
        if (limiteRestante.subtract(valor).compareTo(BigDecimal.ZERO) < 0) {
            throw new BusinessRoleException("Valor limite excedido: " + limiteRestante);
        }

        if (!isParcelaPermitida(pessoa.getValorMinMensal(), valor, parcelas)) {
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

    private BigDecimal getLimiteEmprestimo(PessoaDTO pessoa) {
        BigDecimal totalSolicitado = pessoa.getEmprestimos().stream()
            .map(EmprestimoDTO::getValorEmprestimo)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
            
        return pessoa.getValorMaxEmprestimo().subtract(totalSolicitado);
    }

    private boolean isParcelaPermitida(BigDecimal valorMinMensal, BigDecimal valor, int parcelas) {
        final BigDecimal qtdParcelas = BigDecimal.valueOf(parcelas);
        final BigDecimal valorParcela = valor.divide(qtdParcelas, 4, RoundingMode.HALF_UP);
        if (valorParcela.compareTo(valorMinMensal) >= 0) {
            return true;
        }
        return false;
    }

}
