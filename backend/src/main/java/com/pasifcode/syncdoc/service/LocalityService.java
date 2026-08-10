package com.pasifcode.syncdoc.service;

import com.pasifcode.syncdoc.domain.dto.LocalityDto;

import java.util.List;
import java.util.UUID;

public interface LocalityService {

    LocalityDto create(UUID officeId, LocalityDto dto);

    LocalityDto findById(UUID id);

    List<LocalityDto> findAllByOfficeId(UUID officeId);

    LocalityDto update(UUID localityId, LocalityDto dto);

    void delete(UUID localityId);

}
