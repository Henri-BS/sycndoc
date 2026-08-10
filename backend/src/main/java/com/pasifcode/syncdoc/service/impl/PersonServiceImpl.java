package com.pasifcode.syncdoc.service.impl;

import com.pasifcode.syncdoc.application.exception.DuplicateTuplesException;
import com.pasifcode.syncdoc.application.mapper.PersonMapper;
import com.pasifcode.syncdoc.domain.dto.PersonDto;
import com.pasifcode.syncdoc.domain.entity.Office;
import com.pasifcode.syncdoc.domain.entity.Person;
import com.pasifcode.syncdoc.domain.repository.OfficeRepository;
import com.pasifcode.syncdoc.domain.repository.PersonRepository;
import com.pasifcode.syncdoc.service.PersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final OfficeRepository officeRepository;
    private final PersonMapper personMapper;

    @Override
    @Transactional
    public PersonDto create(UUID officeId, PersonDto dto) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new EntityNotFoundException("Office não encontrado"));

        if (StringUtils.hasText(dto.getCpf())
                && personRepository.existsByOfficeIdAndCpf(officeId, dto.getCpf())) {
            throw new DuplicateTuplesException("Já existe uma pessoa com esse CPF nesse escritório");
        }
        if (StringUtils.hasText(dto.getCnpj())
                && personRepository.existsByOfficeIdAndCnpj(officeId, dto.getCnpj())) {
            throw new DuplicateTuplesException("Já existe uma pessoa com esse CNPJ nesse escritório");
        }

        Person person = personMapper.toEntity(dto);
        person.setOffice(office);
        person.setSequenceNumber(personRepository.findLastSequenceNumber(officeId) + 1);

        return personMapper.toDto(personRepository.save(person));
    }

    @Override
    public PersonDto findById(UUID personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        return personMapper.toDto(person);
    }

    @Override
    public List<PersonDto> findAllByOffice(UUID officeId) {
        return personRepository.findAllByOfficeId(officeId)
                .stream()
                .map(personMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public PersonDto update(UUID personId, PersonDto dto) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));

        if (StringUtils.hasText(dto.getName())) person.setName(dto.getName());
        if (StringUtils.hasText(dto.getCpf())) person.setCpf(dto.getCpf());
        if (StringUtils.hasText(dto.getCnpj())) person.setCnpj(dto.getCnpj());
        if (dto.getRole() != null) person.setRole(dto.getRole());
        if (dto.getGender() != null) person.setGender(dto.getGender());
        if (dto.getBirthDate() != null) person.setBirthDate(dto.getBirthDate());
        if (dto.getMaritalStatus() != null) person.setMaritalStatus(dto.getMaritalStatus());
        if (StringUtils.hasText(dto.getProfession())) person.setProfession(dto.getProfession());
        if (StringUtils.hasText(dto.getRgNumber())) person.setRgNumber(dto.getRgNumber());
        if (dto.getRgIssueDate() != null) person.setRgIssueDate(dto.getRgIssueDate());
        if (StringUtils.hasText(dto.getFatherName())) person.setFatherName(dto.getFatherName());
        if (dto.getFatherBirthDate() != null) person.setFatherBirthDate(dto.getFatherBirthDate());
        if (StringUtils.hasText(dto.getMotherName())) person.setMotherName(dto.getMotherName());
        if (dto.getMotherBirthDate() != null) person.setMotherBirthDate(dto.getMotherBirthDate());

        return personMapper.toDto(personRepository.save(person));
    }

    @Override
    @Transactional
    public void delete(UUID personId) {
        if (!personRepository.existsById(personId)) {
            throw new EntityNotFoundException("Pessoa não encontrada");
        }
        personRepository.deleteById(personId);
    }
}