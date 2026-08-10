package com.pasifcode.syncdoc.application.mapper;

import com.pasifcode.syncdoc.domain.dto.LocalityDto;
import com.pasifcode.syncdoc.domain.entity.Locality;
import org.springframework.stereotype.Component;

@Component
public class LocalityMapper {

    public Locality toEntity(LocalityDto dto){

        if(dto == null){
            return null;
        }

        return Locality.builder()
                .country(dto.getCountry())
                .region(dto.getRegion())
                .state(dto.getState())
                .city(dto.getCity())
                .district(dto.getDistrict())
                .name(dto.getName())
                .zoneType(dto.getZoneType())
                .observations(dto.getObservations())
                .active(dto.getActive())
                .build();

    }

    public LocalityDto toDto(Locality entity){

        if(entity == null){
            return null;
        }

        return LocalityDto.builder()
                .id(entity.getId())
                .sequenceNumber(entity.getSequenceNumber())
                .officeId(entity.getOffice().getId())
                .country(entity.getCountry())
                .region(entity.getRegion())
                .state(entity.getState())
                .city(entity.getCity())
                .district(entity.getDistrict())
                .name(entity.getName())
                .zoneType(entity.getZoneType())
                .observations(entity.getObservations())
                .active(entity.getActive())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}
