package com.pasifcode.syncdoc.application.mapper;

import com.pasifcode.syncdoc.domain.dto.ContactDto;
import com.pasifcode.syncdoc.domain.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactDto toDto(Contact entity) {

        if (entity == null) {
            return null;
        }

        return ContactDto.builder()
                .id(entity.getId())
                .sequenceNumber(entity.getSequenceNumber())
                .personId(entity.getPerson().getId())
                .platform(entity.getPlatform())
                .value(entity.getValue())
                .primaryContact(entity.getPrimaryContact())
                .label(entity.getLabel())
                .active(entity.getActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public Contact toEntity(ContactDto dto) {

        if (dto == null) {
            return null;
        }

        return Contact.builder()
                .platform(dto.getPlatform())
                .value(dto.getValue())
                .primaryContact(dto.getPrimaryContact())
                .label(dto.getLabel())
                .active(dto.getActive())
                .build();
    }
}
