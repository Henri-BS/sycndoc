package com.pasifcode.cma_docs.service;

import com.pasifcode.cma_docs.domain.dto.ClienteDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {
    Page<ClienteDto> findAll(Pageable pageable);

    ClienteDto findById(Long id);

    void saveCliente(ClienteDto dto);

}
