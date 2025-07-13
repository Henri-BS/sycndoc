package com.pasifcode.cma_docs.service;

import com.pasifcode.cma_docs.domain.dto.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    Page<ClientDto> findAll(Pageable pageable);

    ClientDto findById(Long id);

    void saveClient(ClientDto dto);

}
