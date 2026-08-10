package com.pasifcode.syncdoc.application.mapper;

import com.pasifcode.syncdoc.domain.dto.AddressDto;
import com.pasifcode.syncdoc.domain.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto toDto(Address address) {
        if (address == null) {
            return null;
        }

        return AddressDto.builder()
                .sequenceNumber(address.getSequenceNumber())
                .id(address.getId())
                .personId(address.getPerson() != null ? address.getPerson().getId() : null)
                .localityId(address.getLocality() != null ? address.getLocality().getId() : null)
                .number(address.getNumber())
                .complement(address.getComplement())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .directLink(address.getDirectLink())
                .active(address.getActive())
                .build();
    }

    public Address toEntity(AddressDto addressDto) {
        if (addressDto == null) {
            return null;
        }

        return Address.builder()
                .sequenceNumber(addressDto.getSequenceNumber())
                .number(addressDto.getNumber())
                .complement(addressDto.getComplement())
                .latitude(addressDto.getLatitude())
                .longitude(addressDto.getLongitude())
                .directLink(addressDto.getDirectLink())
                .active(addressDto.getActive())
                .build();
    }
}
