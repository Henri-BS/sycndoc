package com.pasifcode.syncdoc.service;

import com.pasifcode.syncdoc.domain.dto.PersonDto;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    PersonDto create(UUID officeId, PersonDto dto);

    PersonDto findById(UUID personId);

    List<PersonDto> findAllByOffice(UUID officeId);

    PersonDto update(UUID personId, PersonDto dto);

    void delete(UUID personId);

}
