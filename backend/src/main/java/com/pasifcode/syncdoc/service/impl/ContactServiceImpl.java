package com.pasifcode.syncdoc.service.impl;

import com.pasifcode.syncdoc.application.mapper.ContactMapper;
import com.pasifcode.syncdoc.domain.dto.ContactDto;
import com.pasifcode.syncdoc.domain.entity.Contact;
import com.pasifcode.syncdoc.domain.entity.Person;
import com.pasifcode.syncdoc.domain.repository.ContactRepository;
import com.pasifcode.syncdoc.domain.repository.PersonRepository;
import com.pasifcode.syncdoc.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final PersonRepository personRepository;
    private final ContactMapper contactMapper;

    @Override
    public ContactDto create(UUID personId, ContactDto dto) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() ->
                        new RuntimeException("Pessoa não encontrada."));

        Long lastSequence = contactRepository.findLastSequenceNumber(personId);

        Contact contact = contactMapper.toEntity(dto);

        contact.setPerson(person);
        contact.setSequenceNumber(lastSequence + 1);

        if (contact.getPrimaryContact() == null) {
            contact.setPrimaryContact(false);
        }

        if (contact.getActive() == null) {
            contact.setActive(true);
        }

        contact = contactRepository.save(contact);

        return contactMapper.toDto(contact);
    }

    @Override
    public ContactDto findById(UUID id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contato não encontrado."));

        return contactMapper.toDto(contact);
    }

    @Override
    public List<ContactDto> findAllByPerson(UUID personId) {

        return contactRepository.findAllByPersonId(personId)
                .stream()
                .map(contactMapper::toDto)
                .toList();
    }

    @Override
    public ContactDto update(UUID id, ContactDto dto) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contato não encontrado."));

        contact.setPlatform(dto.getPlatform());
        contact.setValue(dto.getValue());
        contact.setLabel(dto.getLabel());
        contact.setPrimaryContact(dto.getPrimaryContact());
        contact.setActive(dto.getActive());

        contact = contactRepository.save(contact);

        return contactMapper.toDto(contact);
    }

    @Override
    public void delete(UUID id) {

        Contact contact = contactRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Contato não encontrado."));

        contactRepository.delete(contact);
    }
}
