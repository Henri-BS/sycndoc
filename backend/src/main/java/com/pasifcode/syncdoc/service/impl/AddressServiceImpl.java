package com.pasifcode.syncdoc.service.impl;

import com.pasifcode.syncdoc.application.mapper.AddressMapper;
import com.pasifcode.syncdoc.domain.dto.AddressDto;
import com.pasifcode.syncdoc.domain.entity.Address;
import com.pasifcode.syncdoc.domain.entity.Locality;
import com.pasifcode.syncdoc.domain.entity.Person;
import com.pasifcode.syncdoc.domain.repository.AddressRepository;
import com.pasifcode.syncdoc.domain.repository.LocalityRepository;
import com.pasifcode.syncdoc.domain.repository.PersonRepository;
import com.pasifcode.syncdoc.service.AddressService;
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
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final LocalityRepository localityRepository;
    private final AddressMapper addressMapper;

    @Override
    @Transactional
    public AddressDto create(UUID personId, AddressDto dto) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        Locality locality = localityRepository.findById(dto.getLocalityId())
                .orElseThrow(() -> new EntityNotFoundException("Localidade não encontrada"));

        Address address = addressMapper.toEntity(dto);
        address.setPerson(person);
        address.setLocality(locality);
        address.setSequenceNumber(addressRepository.findLastSequenceNumber(personId) + 1);
        if (address.getActive() == null) address.setActive(true);

        return addressMapper.toDto(addressRepository.save(address));
    }

    @Override
    public AddressDto findById(UUID addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));
        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressDto> findAllByPersonId(UUID personId) {
        return addressRepository.findAllByPersonId(personId)
                .stream().map(addressMapper::toDto).toList();
    }

    @Override
    @Transactional
    public AddressDto update(UUID addressId, AddressDto dto) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Endereço não encontrado"));

        if (dto.getLocalityId() != null) {
            Locality locality = localityRepository.findById(dto.getLocalityId())
                    .orElseThrow(() -> new EntityNotFoundException("Localidade não encontrada"));
            address.setLocality(locality);
        }
        if (StringUtils.hasText(dto.getNumber())) address.setNumber(dto.getNumber());
        if (StringUtils.hasText(dto.getComplement())) address.setComplement(dto.getComplement());
        if (dto.getLatitude() != null) address.setLatitude(dto.getLatitude());
        if (dto.getLongitude() != null) address.setLongitude(dto.getLongitude());
        if (StringUtils.hasText(dto.getDirectLink())) address.setDirectLink(dto.getDirectLink());
        if (dto.getActive() != null) address.setActive(dto.getActive());

        return addressMapper.toDto(addressRepository.save(address));
    }

    @Override
    @Transactional
    public void delete(UUID addressId) {
        if (!addressRepository.existsById(addressId)) {
            throw new EntityNotFoundException("Endereço não encontrado");
        }
        addressRepository.deleteById(addressId);
    }
}