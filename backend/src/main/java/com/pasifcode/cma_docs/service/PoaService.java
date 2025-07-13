package com.pasifcode.cma_docs.service;

import com.pasifcode.cma_docs.domain.dto.PoaDto;
import com.pasifcode.cma_docs.domain.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PoaService {
    Page<PoaDto> findAll(Long clientId, Pageable pageable);

    PoaDto findById(Long id);

    void saveDocumentByClient(Client client);
}
