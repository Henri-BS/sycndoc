package com.pasifcode.cma_docs.service.impl;

import com.pasifcode.cma_docs.domain.dto.ClientDto;
import com.pasifcode.cma_docs.domain.entity.Client;
import com.pasifcode.cma_docs.domain.entity.User;
import com.pasifcode.cma_docs.domain.repository.ClientRepository;
import com.pasifcode.cma_docs.domain.repository.UserRepository;
import com.pasifcode.cma_docs.service.ClientService;
import com.pasifcode.cma_docs.service.PoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final PoaService poaService;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, UserRepository userRepository, PoaService poaService) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.poaService = poaService;
    }

    @Override
    public Page<ClientDto> findAll(Pageable pageable) {
        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(ClientDto::new);
    }

    @Override
    public ClientDto findById(Long id) {
        Client find = clientRepository.findById(id).orElseThrow();
        return new ClientDto(find);
    }

    @Override
    public void saveCliente(ClientDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow();

        Client add = new Client();
        add.setClientName(dto.getClientName());
        add.setClientNationality(dto.getClientNationality());
        add.setClientMaritalStatus(dto.getClientMaritalStatus());
        add.setClientProfession(dto.getClientProfession());
        add.setClientRgNumber(dto.getClientRgNumber());
        add.setClientRgIssueDate(dto.getClientRgIssueDate());
        add.setClientCpf(dto.getClientCpf());
        add.setClientBirthDate(dto.getClientBirthDate());
        add.setClientRelatives(dto.getClientRelatives());
        add.setClientAddress(dto.getClientAddress());
        add.setClientResidentialNumber(dto.getClientResidentialNumber());
        add.setClientDistrict(dto.getClientDistrict());
        add.setClientCity(dto.getClientCity());
        add.setClientUf(dto.getClientUf());
        add.setClientCep(dto.getClientCep());
        add.setProxyName(dto.getProxyName());
        add.setProxyCpf(dto.getProxyCpf());
        add.setProxyRg(dto.getProxyRg());
        add.setProxyRelatives(dto.getProxyRelatives());
        add.setProxyAddress(dto.getProxyAddress());
        add.setProxyDistrict(dto.getProxyDistrict());
        add.setProxyCity(dto.getProxyCity());
        add.setProxyUf(dto.getProxyUf());
        add.setProxyCep(dto.getProxyCep());
        add.setWitness1Name(dto.getWitness1Name());
        add.setWitness1Rg(dto.getWitness1Rg());
        add.setWitness1Cpf(dto.getWitness1Cpf());
        add.setWitness2Name(dto.getWitness2Name());
        add.setWitness2Rg(dto.getWitness2Rg());
        add.setWitness2Cpf(dto.getWitness2Cpf());
        add.setUser(user);

        clientRepository.saveAndFlush(add);
        Client client = clientRepository.findById(add.getId()).orElseThrow();
        poaService.saveDocumentByClient(client);
    }
}
