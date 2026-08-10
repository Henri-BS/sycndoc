package com.pasifcode.syncdoc.service;

import com.pasifcode.syncdoc.domain.dto.OfficeDto;

import java.util.List;
import java.util.UUID;

public interface OfficeService {

    OfficeDto create(OfficeDto dto);

    OfficeDto findById(UUID officeId);

    List<OfficeDto> findAll();

    OfficeDto update(UUID officeId, OfficeDto dto);

    void delete(UUID officeId);

}
