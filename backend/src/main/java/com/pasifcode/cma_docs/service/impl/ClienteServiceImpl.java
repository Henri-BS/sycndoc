package com.pasifcode.cma_docs.service.impl;

import com.pasifcode.cma_docs.domain.dto.ClienteDto;
import com.pasifcode.cma_docs.domain.entity.Cliente;
import com.pasifcode.cma_docs.domain.entity.User;
import com.pasifcode.cma_docs.domain.repository.ClienteRepository;
import com.pasifcode.cma_docs.domain.repository.UserRepository;
import com.pasifcode.cma_docs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final UserRepository userRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, UserRepository userRepository) {
        this.clienteRepository = clienteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Page<ClienteDto> findAll(Pageable pageable) {
        Page<Cliente> page = clienteRepository.findAll(pageable);
        return page.map(ClienteDto::new);
    }

    @Override
    public ClienteDto findById(Long id) {
        Cliente find = clienteRepository.findById(id).orElseThrow();
        return new ClienteDto(find);
    }

    @Override
    public void saveCliente(ClienteDto dto) {
        User user = userRepository.findById(dto.getIdUsuario()).orElseThrow();

        Cliente add = new Cliente();
        add.setNomeCliente(dto.getNomeCliente());
        add.setNacionalidadeCliente(dto.getNacionalidadeCliente());
        add.setEstadoCivilCliente(dto.getEstadoCivilCliente());
        add.setProfissaoCliente(dto.getProfissaoCliente());
        add.setNumeroRgCliente(dto.getNumeroRgCliente());
        add.setDataEmissaoRgCliente(dto.getDataEmissaoRgCliente());
        add.setCpfCliente(dto.getCpfCliente());
        add.setDataNascimentoCliente(dto.getDataNascimentoCliente());
        add.setParentesCliente(dto.getParentesCliente());
        add.setEnderecoCliente(dto.getEnderecoCliente());
        add.setBairroCliente(dto.getBairroCliente());
        add.setCidadeCliente(dto.getCidadeCliente());
        add.setEstadoCliente(dto.getEstadoCliente());
        add.setCepCliente(dto.getCepCliente());
        add.setNomeRogado(dto.getNomeRogado());
        add.setCpfRogado(dto.getCpfRogado());
        add.setRgRogado(dto.getRgRogado());
        add.setParentesRogado(dto.getParentesRogado());
        add.setEnderecoRogado(dto.getEnderecoRogado());
        add.setBairroRogado(dto.getBairroRogado());
        add.setCidadeRogado(dto.getCidadeRogado());
        add.setEstadoRogado(dto.getEstadoRogado());
        add.setCepRogado(dto.getCepRogado());
        add.setNomeTestemunha1(dto.getNomeTestemunha1());
        add.setRgTestemunha1(dto.getRgTestemunha1());
        add.setCpfTestemunha1(dto.getCpfTestemunha1());
        add.setNomeTestemunha2(dto.getNomeTestemunha2());
        add.setRgTestemunha2(dto.getRgTestemunha2());
        add.setCpfTestemunha2(dto.getCpfTestemunha2());
        add.setUser(user);

        clienteRepository.saveAndFlush(add);
    }
}
