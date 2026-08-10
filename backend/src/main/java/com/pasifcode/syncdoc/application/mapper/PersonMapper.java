package com.pasifcode.syncdoc.application.mapper;

import com.pasifcode.syncdoc.domain.dto.PersonDto;
import com.pasifcode.syncdoc.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonMapper {

    public PersonDto toDto(Person entity) {

        if (entity == null) {
            return null;
        }

        return PersonDto.builder()
                .id(entity.getId())
                .sequenceNumber(entity.getSequenceNumber())
                .name(entity.getName())
                .cpf(entity.getCpf())
                .cnpj(entity.getCnpj())
                .birthDate(entity.getBirthDate())
                .role(entity.getRole())
                .gender(entity.getGender())
                .maritalStatus(entity.getMaritalStatus())
                .profession(entity.getProfession())
                .rgNumber(entity.getRgNumber())
                .rgIssueDate(entity.getRgIssueDate())
                .fatherName(entity.getFatherName())
                .fatherBirthDate(entity.getFatherBirthDate())
                .motherName(entity.getMotherName())
                .motherBirthDate(entity.getMotherBirthDate())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public Person toEntity(PersonDto dto) {
        if (dto == null) return null;

        return Person.builder()
                .name(dto.getName())
                .cpf(dto.getCpf())
                .cnpj(dto.getCnpj())
                .role(dto.getRole())
                .gender(dto.getGender())
                .birthDate(dto.getBirthDate())
                .maritalStatus(dto.getMaritalStatus())
                .profession(dto.getProfession())
                .rgNumber(dto.getRgNumber())
                .rgIssueDate(dto.getRgIssueDate())
                .fatherName(dto.getFatherName())
                .fatherBirthDate(dto.getFatherBirthDate())
                .motherName(dto.getMotherName())
                .motherBirthDate(dto.getMotherBirthDate())
                .build();
    }
}