package com.pasifcode.cma_docs.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
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


    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "client")
    private Set<Poa> poas = new HashSet<>();

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientNationality() {
        return clientNationality;
    }

    public void setClientNationality(String clientNationality) {
        this.clientNationality = clientNationality;
    }

    public String getClientMaritalStatus() {
        return clientMaritalStatus;
    }

    public void setClientMaritalStatus(String clientMaritalStatus) {
        this.clientMaritalStatus = clientMaritalStatus;
    }

    public String getClientProfession() {
        return clientProfession;
    }

    public void setClientProfession(String clientProfession) {
        this.clientProfession = clientProfession;
    }

    public String getClientRgNumber() {
        return clientRgNumber;
    }

    public void setClientRgNumber(String clientRgNumber) {
        this.clientRgNumber = clientRgNumber;
    }

    public LocalDate getClientRgIssueDate() {
        return clientRgIssueDate;
    }

    public void setClientRgIssueDate(LocalDate clientRgIssueDate) {
        this.clientRgIssueDate = clientRgIssueDate;
    }

    public String getClientCpf() {
        return clientCpf;
    }

    public void setClientCpf(String clientCpf) {
        this.clientCpf = clientCpf;
    }

    public LocalDate getClientBirthDate() {
        return clientBirthDate;
    }

    public void setClientBirthDate(LocalDate clientBirthDate) {
        this.clientBirthDate = clientBirthDate;
    }

    public String getClientRelatives() {
        return clientRelatives;
    }

    public void setClientRelatives(String clientRelatives) {
        this.clientRelatives = clientRelatives;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientResidentialNumber() {
        return clientResidentialNumber;
    }

    public void setClientResidentialNumber(String clientResidentialNumber) {
        this.clientResidentialNumber = clientResidentialNumber;
    }

    public String getClientDistrict() {
        return clientDistrict;
    }

    public void setClientDistrict(String clientDistrict) {
        this.clientDistrict = clientDistrict;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientUf() {
        return clientUf;
    }

    public void setClientUf(String clientUf) {
        this.clientUf = clientUf;
    }

    public String getClientCep() {
        return clientCep;
    }

    public void setClientCep(String clientCep) {
        this.clientCep = clientCep;
    }

    public String getProxyName() {
        return proxyName;
    }

    public void setProxyName(String proxyName) {
        this.proxyName = proxyName;
    }

    public String getProxyCpf() {
        return proxyCpf;
    }

    public void setProxyCpf(String proxyCpf) {
        this.proxyCpf = proxyCpf;
    }

    public String getProxyRg() {
        return proxyRg;
    }

    public void setProxyRg(String proxyRg) {
        this.proxyRg = proxyRg;
    }

    public String getProxyRelatives() {
        return proxyRelatives;
    }

    public void setProxyRelatives(String proxyRelatives) {
        this.proxyRelatives = proxyRelatives;
    }

    public String getProxyAddress() {
        return proxyAddress;
    }

    public void setProxyAddress(String proxyAddress) {
        this.proxyAddress = proxyAddress;
    }

    public String getProxyDistrict() {
        return proxyDistrict;
    }

    public void setProxyDistrict(String proxyDistrict) {
        this.proxyDistrict = proxyDistrict;
    }

    public String getProxyCity() {
        return proxyCity;
    }

    public void setProxyCity(String proxyCity) {
        this.proxyCity = proxyCity;
    }

    public String getProxyUf() {
        return proxyUf;
    }

    public void setProxyUf(String proxyUf) {
        this.proxyUf = proxyUf;
    }

    public String getProxyCep() {
        return proxyCep;
    }

    public void setProxyCep(String proxyCep) {
        this.proxyCep = proxyCep;
    }

    public String getWitness1Name() {
        return witness1Name;
    }

    public void setWitness1Name(String witness1Name) {
        this.witness1Name = witness1Name;
    }

    public String getWitness1Rg() {
        return witness1Rg;
    }

    public void setWitness1Rg(String witness1Rg) {
        this.witness1Rg = witness1Rg;
    }

    public String getWitness1Cpf() {
        return witness1Cpf;
    }

    public void setWitness1Cpf(String witness1Cpf) {
        this.witness1Cpf = witness1Cpf;
    }

    public String getWitness2Name() {
        return witness2Name;
    }

    public void setWitness2Name(String witness2Name) {
        this.witness2Name = witness2Name;
    }

    public String getWitness2Rg() {
        return witness2Rg;
    }

    public void setWitness2Rg(String witness2Rg) {
        this.witness2Rg = witness2Rg;
    }

    public String getWitness2Cpf() {
        return witness2Cpf;
    }

    public void setWitness2Cpf(String witness2Cpf) {
        this.witness2Cpf = witness2Cpf;
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