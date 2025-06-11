package com.pasifcode.cma_docs.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pasifcode.cma_docs.domain.entity.Client;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClientDto {
    private Long id;
    private String clientName;
    private String clientNationality;
    private String clientMaritalStatus;
    private String clientProfession;
    private String clientRgNumber;
    private LocalDate clientRgIssueDate;
    private String clientCpf;
    private LocalDate clientBirthDate;
    private String clientRelatives;
    private String clientAddress;
    private String clientResidentialNumber;
    private String clientDistrict;
    private String clientCity;
    private String clientUf;
    private String clientCep;

    private String proxyName;
    private String proxyCpf;
    private String proxyRg;
    private String proxyRelatives;
    private String proxyAddress;
    private String proxyDistrict;
    private String proxyCity;
    private String proxyUf;
    private String proxyCep;

    private String witness1Name;
    private String witness1Rg;
    private String witness1Cpf;

    private String witness2Name;
    private String witness2Rg;
    private String witness2Cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime createdDate;

    private Long userId;
    private String username;

    @JsonCreator
    public ClientDto() {
    }

    public ClientDto(Client client) {
        id = client.getId();
        clientName = client.getClientName();
        clientNationality = client.getClientNationality();
        clientMaritalStatus = client.getClientMaritalStatus();
        clientProfession = client.getClientProfession();
        clientRgNumber = client.getClientRgNumber();
        clientRgIssueDate = client.getClientRgIssueDate();
        clientCpf = client.getClientCpf();
        clientBirthDate = client.getClientBirthDate();
        clientRelatives = client.getClientRelatives();
        clientAddress = client.getClientAddress();
        clientResidentialNumber = client.getClientResidentialNumber();
        clientDistrict = client.getClientDistrict();
        clientCity = client.getClientCity();
        clientUf = client.getClientUf();
        clientCep = client.getClientCep();

        proxyName = client.getProxyName();
        proxyCpf = client.getProxyCpf();
        proxyRg = client.getProxyRg();
        proxyRelatives = client.getProxyRelatives();
        proxyAddress = client.getProxyAddress();
        proxyDistrict = client.getProxyDistrict();
        proxyCity = client.getProxyCity();
        proxyUf = client.getProxyUf();
        proxyCep = client.getProxyCep();

        witness1Name = client.getWitness1Name();
        witness1Rg = client.getWitness1Rg();
        witness1Cpf = client.getWitness1Cpf();

        witness2Name = client.getWitness2Name();
        witness2Rg = client.getWitness2Rg();
        witness2Cpf = client.getWitness2Cpf();

        createdDate = client.getCreatedDate();
        userId = client.getUser().getId();
        username = client.getUser().getUsername();
    }

    public Long getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientNationality() {
        return clientNationality;
    }

    public String getClientMaritalStatus() {
        return clientMaritalStatus;
    }

    public String getClientProfession() {
        return clientProfession;
    }

    public String getClientRgNumber() {
        return clientRgNumber;
    }

    public LocalDate getClientRgIssueDate() {
        return clientRgIssueDate;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public LocalDate getClientBirthDate() {
        return clientBirthDate;
    }

    public String getClientRelatives() {
        return clientRelatives;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientResidentialNumber() {
        return clientResidentialNumber;
    }

    public String getClientDistrict() {
        return clientDistrict;
    }

    public String getClientCity() {
        return clientCity;
    }

    public String getClientUf() {
        return clientUf;
    }

    public String getClientCep() {
        return clientCep;
    }

    public String getProxyName() {
        return proxyName;
    }

    public String getProxyCpf() {
        return proxyCpf;
    }

    public String getProxyRg() {
        return proxyRg;
    }

    public String getProxyRelatives() {
        return proxyRelatives;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }

    public String getProxyDistrict() {
        return proxyDistrict;
    }

    public String getProxyCity() {
        return proxyCity;
    }

    public String getProxyUf() {
        return proxyUf;
    }

    public String getProxyCep() {
        return proxyCep;
    }

    public String getWitness1Name() {
        return witness1Name;
    }

    public String getWitness1Rg() {
        return witness1Rg;
    }

    public String getWitness1Cpf() {
        return witness1Cpf;
    }

    public String getWitness2Name() {
        return witness2Name;
    }

    public String getWitness2Rg() {
        return witness2Rg;
    }

    public String getWitness2Cpf() {
        return witness2Cpf;
    }

    @JsonProperty
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @JsonProperty
    public Long getUserId() {
        return userId;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }
}
