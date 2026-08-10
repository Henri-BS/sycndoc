package com.pasifcode.syncdoc.service.impl;

import com.pasifcode.syncdoc.application.exception.DuplicateTuplesException;
import com.pasifcode.syncdoc.application.mapper.LocalityMapper;
import com.pasifcode.syncdoc.domain.dto.LocalityDto;
import com.pasifcode.syncdoc.domain.entity.Locality;
import com.pasifcode.syncdoc.domain.entity.Office;
import com.pasifcode.syncdoc.domain.repository.LocalityRepository;
import com.pasifcode.syncdoc.domain.repository.OfficeRepository;
import com.pasifcode.syncdoc.service.LocalityService;
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
public class LocalityServiceImpl implements LocalityService {

    private final LocalityRepository localityRepository;
    private final OfficeRepository officeRepository;
    private final LocalityMapper localityMapper;

    @Override
    @Transactional
    public LocalityDto create(UUID officeId, LocalityDto dto) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new EntityNotFoundException("Office não encontrado"));

        if (localityRepository.findByOfficeIdAndNameIgnoreCase(officeId, dto.getName()).isPresent()) {
            throw new DuplicateTuplesException("Já existe uma localidade com esse nome nesse escritório");
        }

        Locality locality = localityMapper.toEntity(dto);
        locality.setOffice(office);
        locality.setSequenceNumber(localityRepository.findLastSequenceNumber(officeId) + 1);
        if (locality.getActive() == null) locality.setActive(true);

        return localityMapper.toDto(localityRepository.save(locality));
    }

    @Override
    public LocalityDto findById(UUID id) {
        Locality locality = localityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Localidade não encontrada"));
        return localityMapper.toDto(locality);
    }

    @Override
    public List<LocalityDto> findAllByOfficeId(UUID officeId) {
        return localityRepository.findAllByOfficeId(officeId)
                .stream().map(localityMapper::toDto).toList();
    }

    @Override
    @Transactional
    public LocalityDto update(UUID localityId, LocalityDto dto) {
        Locality locality = localityRepository.findById(localityId)
                .orElseThrow(() -> new EntityNotFoundException("Localidade não encontrada"));

        if (StringUtils.hasText(dto.getCountry())) locality.setCountry(dto.getCountry());
        if (StringUtils.hasText(dto.getRegion())) locality.setRegion(dto.getRegion());
        if (StringUtils.hasText(dto.getState())) locality.setState(dto.getState());
        if (StringUtils.hasText(dto.getCity())) locality.setCity(dto.getCity());
        if (StringUtils.hasText(dto.getDistrict())) locality.setDistrict(dto.getDistrict());
        if (StringUtils.hasText(dto.getName())) locality.setName(dto.getName());
        if (dto.getZoneType() != null) locality.setZoneType(dto.getZoneType());
        if (StringUtils.hasText(dto.getObservations())) locality.setObservations(dto.getObservations());
        if (dto.getActive() != null) locality.setActive(dto.getActive());

        return localityMapper.toDto(localityRepository.save(locality));
    }

    @Override
    @Transactional
    public void delete(UUID localityId) {
        if (!localityRepository.existsById(localityId)) {
            throw new EntityNotFoundException("Localidade não encontrada");
        }
        localityRepository.deleteById(localityId);
    }
}