package com.pasifcode.syncdoc.service.impl;

import com.pasifcode.syncdoc.application.exception.DuplicateTuplesException;
import com.pasifcode.syncdoc.application.mapper.OfficeMapper;
import com.pasifcode.syncdoc.domain.dto.OfficeDto;
import com.pasifcode.syncdoc.domain.entity.Office;
import com.pasifcode.syncdoc.domain.repository.OfficeRepository;
import com.pasifcode.syncdoc.service.OfficeService;
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
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;
    private final OfficeMapper officeMapper;

    @Override
    @Transactional
    public OfficeDto create(OfficeDto dto) {
        if (officeRepository.existsByAcronym(dto.getAcronym())) {
            throw new DuplicateTuplesException("Já existe um escritório com essa sigla");
        }
        if (StringUtils.hasText(dto.getCnpj()) && officeRepository.existsByCnpj(dto.getCnpj())) {
            throw new DuplicateTuplesException("Já existe um escritório com esse CNPJ");
        }

        Office office = officeMapper.toEntity(dto);
        if (office.getActive() == null) {
            office.setActive(true);
        }

        return officeMapper.toDto(officeRepository.save(office));
    }

    @Override
    public OfficeDto findById(UUID officeId) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new EntityNotFoundException("Office não encontrado"));
        return officeMapper.toDto(office);
    }

    @Override
    public List<OfficeDto> findAll() {
        return officeRepository.findAll()
                .stream()
                .map(officeMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public OfficeDto update(UUID officeId, OfficeDto dto) {
        Office office = officeRepository.findById(officeId)
                .orElseThrow(() -> new EntityNotFoundException("Office não encontrado"));

        if (StringUtils.hasText(dto.getName())) office.setName(dto.getName());
        if (StringUtils.hasText(dto.getAcronym())) office.setAcronym(dto.getAcronym());
        if (StringUtils.hasText(dto.getCnpj())) office.setCnpj(dto.getCnpj());
        if (StringUtils.hasText(dto.getEmail())) office.setEmail(dto.getEmail());
        if (StringUtils.hasText(dto.getWebsite())) office.setWebsite(dto.getWebsite());
        if (dto.getActive() != null) office.setActive(dto.getActive());

        return officeMapper.toDto(officeRepository.save(office));
    }

    @Override
    @Transactional
    public void delete(UUID officeId) {
        if (!officeRepository.existsById(officeId)) {
            throw new EntityNotFoundException("Office não encontrado");
        }
        officeRepository.deleteById(officeId);
    }
}