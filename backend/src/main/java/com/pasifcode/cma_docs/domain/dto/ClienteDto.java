package com.pasifcode.cma_docs.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pasifcode.cma_docs.domain.entity.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClienteDto {
    private Long id;
    private String nomeCliente;
    private String nacionalidadeCliente;
    private String estadoCivilCliente;
    private String profissaoCliente;
    private String numeroRgCliente;
    private LocalDate dataEmissaoRgCliente;
    private String cpfCliente;
    private LocalDate dataNascimentoCliente;
    private String parentesCliente;
    private String enderecoCliente;
    private String bairroCliente;
    private String cidadeCliente;
    private String estadoCliente;
    private String cepCliente;

    private String nomeRogado;
    private String cpfRogado;
    private String rgRogado;
    private String parentesRogado;
    private String enderecoRogado;
    private String bairroRogado;
    private String cidadeRogado;
    private String estadoRogado;
    private String cepRogado;

    private String nomeTestemunha1;
    private String rgTestemunha1;
    private String cpfTestemunha1;

    private String nomeTestemunha2;
    private String rgTestemunha2;
    private String cpfTestemunha2;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;

    private Long idUsuario;
    private String nomeUsuario;

    @JsonCreator
    public ClienteDto() {
    }

    public ClienteDto(Cliente cliente) {
        id = cliente.getId();
        nomeCliente = cliente.getNomeCliente();
        nacionalidadeCliente = cliente.getNacionalidadeCliente();
        estadoCivilCliente = cliente.getEstadoCivilCliente();
        profissaoCliente = cliente.getProfissaoCliente();
        numeroRgCliente = cliente.getNumeroRgCliente();
        dataEmissaoRgCliente = cliente.getDataEmissaoRgCliente();
        cpfCliente = cliente.getCpfCliente();
        dataNascimentoCliente = cliente.getDataNascimentoCliente();
        parentesCliente = cliente.getParentesCliente();
        enderecoCliente = cliente.getEnderecoCliente();
        bairroCliente = cliente.getBairroCliente();
        cidadeCliente = cliente.getCidadeCliente();
        estadoCliente = cliente.getEstadoCliente();
        cepCliente = cliente.getCepCliente();
        nomeRogado = cliente.getNomeRogado();
        cpfRogado = cliente.getCpfRogado();
        rgRogado = cliente.getRgRogado();
        parentesRogado = cliente.getParentesRogado();
        enderecoRogado = cliente.getEnderecoRogado();
        bairroRogado = cliente.getBairroRogado();
        cidadeRogado = cliente.getCidadeRogado();
        estadoRogado = cliente.getEstadoRogado();
        cepRogado = cliente.getCepRogado();
        nomeTestemunha1 = cliente.getNomeTestemunha1();
        rgTestemunha1 = cliente.getRgTestemunha1();
        cpfTestemunha1 = cliente.getCpfTestemunha1();
        nomeTestemunha2 = cliente.getNomeTestemunha2();
        rgTestemunha2 = cliente.getRgTestemunha2();
        cpfTestemunha2 = cliente.getCpfTestemunha2();
        createdDate = cliente.getCreatedDate();
        idUsuario = cliente.getUser().getId();
        nomeUsuario = cliente.getUser().getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNacionalidadeCliente() {
        return nacionalidadeCliente;
    }

    public String getEstadoCivilCliente() {
        return estadoCivilCliente;
    }

    public String getProfissaoCliente() {
        return profissaoCliente;
    }

    public String getNumeroRgCliente() {
        return numeroRgCliente;
    }

    public LocalDate getDataEmissaoRgCliente() {
        return dataEmissaoRgCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public LocalDate getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public String getParentesCliente() {
        return parentesCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public String getNomeRogado() {
        return nomeRogado;
    }

    public String getCpfRogado() {
        return cpfRogado;
    }

    public String getRgRogado() {
        return rgRogado;
    }

    public String getParentesRogado() {
        return parentesRogado;
    }

    public String getEnderecoRogado() {
        return enderecoRogado;
    }

    public String getBairroRogado() {
        return bairroRogado;
    }

    public String getCidadeRogado() {
        return cidadeRogado;
    }

    public String getEstadoRogado() {
        return estadoRogado;
    }

    public String getCepRogado() {
        return cepRogado;
    }

    public String getNomeTestemunha1() {
        return nomeTestemunha1;
    }

    public String getRgTestemunha1() {
        return rgTestemunha1;
    }

    public String getCpfTestemunha1() {
        return cpfTestemunha1;
    }

    public String getNomeTestemunha2() {
        return nomeTestemunha2;
    }

    public String getRgTestemunha2() {
        return rgTestemunha2;
    }

    public String getCpfTestemunha2() {
        return cpfTestemunha2;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    @JsonProperty
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    @JsonProperty
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
}
