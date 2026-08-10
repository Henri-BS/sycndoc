package com.pasifcode.syncdoc.service;

import com.pasifcode.syncdoc.domain.dto.AddressDto;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    AddressDto create(UUID personId, AddressDto dto);

    AddressDto findById(UUID addressId);

    List<AddressDto> findAllByPersonId(UUID personId);

    AddressDto update(UUID addressId, AddressDto dto);

    void delete(UUID addressId);
}
