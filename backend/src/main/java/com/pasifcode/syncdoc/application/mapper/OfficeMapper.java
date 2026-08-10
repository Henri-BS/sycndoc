package com.pasifcode.syncdoc.application.mapper;

import com.pasifcode.syncdoc.domain.dto.OfficeDto;
import com.pasifcode.syncdoc.domain.entity.Office;
import org.springframework.stereotype.Component;

@Component
public class OfficeMapper {

    public OfficeDto toDto(Office entity) {

        if (entity == null) {
            return null;
        }

        return OfficeDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .acronym(entity.getAcronym())
                .cnpj(entity.getCnpj())
                .email(entity.getEmail())
                .website(entity.getWebsite())
                .active(entity.getActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public Office toEntity(OfficeDto dto) {

        if (dto == null) {
            return null;
        }

        return Office.builder()
                .name(dto.getName())
                .acronym(dto.getAcronym())
                .cnpj(dto.getCnpj())
                .email(dto.getEmail())
                .website(dto.getWebsite())
                .active(dto.getActive())
                .build();
    }
}
