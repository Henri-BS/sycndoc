package com.pasifcode.syncdoc.application.controller;

import com.pasifcode.syncdoc.domain.dto.AddressDto;
import com.pasifcode.syncdoc.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/persons/{personId}/addresses")
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto create(@PathVariable UUID personId, @RequestBody AddressDto dto) {
        return addressService.create(personId, dto);
    }

    @GetMapping("/persons/{personId}/addresses")
    public List<AddressDto> findAllByPerson(@PathVariable UUID personId) {
        return addressService.findAllByPersonId(personId);
    }

    @GetMapping("/addresses/{addressId}")
    public AddressDto findById(@PathVariable UUID addressId) {
        return addressService.findById(addressId);
    }

    @PutMapping("/addresses/{addressId}")
    public AddressDto update(@PathVariable UUID addressId, @RequestBody AddressDto dto) {
        return addressService.update(addressId, dto);
    }

    @DeleteMapping("/addresses/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID addressId) {
        addressService.delete(addressId);
    }

}
