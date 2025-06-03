package com.pasifcode.cma_docs.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_client")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
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

    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNacionalidadeCliente() {
        return nacionalidadeCliente;
    }

    public void setNacionalidadeCliente(String nacionalidadeCliente) {
        this.nacionalidadeCliente = nacionalidadeCliente;
    }

    public String getEstadoCivilCliente() {
        return estadoCivilCliente;
    }

    public void setEstadoCivilCliente(String estadoCivilCliente) {
        this.estadoCivilCliente = estadoCivilCliente;
    }

    public String getProfissaoCliente() {
        return profissaoCliente;
    }

    public void setProfissaoCliente(String profissaoCliente) {
        this.profissaoCliente = profissaoCliente;
    }

    public String getNumeroRgCliente() {
        return numeroRgCliente;
    }

    public void setNumeroRgCliente(String numeroRgCliente) {
        this.numeroRgCliente = numeroRgCliente;
    }

    public LocalDate getDataEmissaoRgCliente() {
        return dataEmissaoRgCliente;
    }

    public void setDataEmissaoRgCliente(LocalDate dataEmissaoRgCliente) {
        this.dataEmissaoRgCliente = dataEmissaoRgCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public LocalDate getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(LocalDate dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public String getParentesCliente() {
        return parentesCliente;
    }

    public void setParentesCliente(String parentesCliente) {
        this.parentesCliente = parentesCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getBairroCliente() {
        return bairroCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getCidadeCliente() {
        return cidadeCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getNomeRogado() {
        return nomeRogado;
    }

    public void setNomeRogado(String nomeRogado) {
        this.nomeRogado = nomeRogado;
    }

    public String getCpfRogado() {
        return cpfRogado;
    }

    public void setCpfRogado(String cpfRogado) {
        this.cpfRogado = cpfRogado;
    }

    public String getRgRogado() {
        return rgRogado;
    }

    public void setRgRogado(String rgRogado) {
        this.rgRogado = rgRogado;
    }

    public String getParentesRogado() {
        return parentesRogado;
    }

    public void setParentesRogado(String parentesRogado) {
        this.parentesRogado = parentesRogado;
    }

    public String getEnderecoRogado() {
        return enderecoRogado;
    }

    public void setEnderecoRogado(String enderecoRogado) {
        this.enderecoRogado = enderecoRogado;
    }

    public String getBairroRogado() {
        return bairroRogado;
    }

    public void setBairroRogado(String bairroRogado) {
        this.bairroRogado = bairroRogado;
    }

    public String getCidadeRogado() {
        return cidadeRogado;
    }

    public void setCidadeRogado(String cidadeRogado) {
        this.cidadeRogado = cidadeRogado;
    }

    public String getEstadoRogado() {
        return estadoRogado;
    }

    public void setEstadoRogado(String estadoRogado) {
        this.estadoRogado = estadoRogado;
    }

    public String getCepRogado() {
        return cepRogado;
    }

    public void setCepRogado(String cepRogado) {
        this.cepRogado = cepRogado;
    }

    public String getNomeTestemunha1() {
        return nomeTestemunha1;
    }

    public void setNomeTestemunha1(String nomeTestemunha1) {
        this.nomeTestemunha1 = nomeTestemunha1;
    }

    public String getRgTestemunha1() {
        return rgTestemunha1;
    }

    public void setRgTestemunha1(String rgTestemunha1) {
        this.rgTestemunha1 = rgTestemunha1;
    }

    public String getCpfTestemunha1() {
        return cpfTestemunha1;
    }

    public void setCpfTestemunha1(String cpfTestemunha1) {
        this.cpfTestemunha1 = cpfTestemunha1;
    }

    public String getNomeTestemunha2() {
        return nomeTestemunha2;
    }

    public void setNomeTestemunha2(String nomeTestemunha2) {
        this.nomeTestemunha2 = nomeTestemunha2;
    }

    public String getRgTestemunha2() {
        return rgTestemunha2;
    }

    public void setRgTestemunha2(String rgTestemunha2) {
        this.rgTestemunha2 = rgTestemunha2;
    }

    public String getCpfTestemunha2() {
        return cpfTestemunha2;
    }

    public void setCpfTestemunha2(String cpfTestemunha2) {
        this.cpfTestemunha2 = cpfTestemunha2;
    }

    @JsonProperty
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}