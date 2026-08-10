package com.pasifcode.syncdoc.service;

import com.pasifcode.syncdoc.domain.dto.ContactDto;

import java.util.List;
import java.util.UUID;

public interface ContactService {

    ContactDto create(UUID personId, ContactDto dto);

    ContactDto findById(UUID id);

    List<ContactDto> findAllByPerson(UUID personId);

    ContactDto update(UUID id, ContactDto dto);

    void delete(UUID id);

}