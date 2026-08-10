package com.pasifcode.syncdoc.application.controller;

import com.pasifcode.syncdoc.domain.dto.ContactDto;
import com.pasifcode.syncdoc.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping("/persons/{personId}/contacts")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDto create(
            @PathVariable UUID personId,
            @RequestBody ContactDto dto
    ) {

        return contactService.create(personId, dto);
    }

    @GetMapping("/persons/{personId}/contacts")
    public List<ContactDto> findAllByPerson(
            @PathVariable UUID personId
    ) {

        return contactService.findAllByPerson(personId);
    }

    @GetMapping("/contacts/{contactId}")
    public ContactDto findById(
            @PathVariable UUID contactId
    ) {

        return contactService.findById(contactId);
    }

    @PutMapping("/contacts/{contactId}")
    public ContactDto update(
            @PathVariable UUID contactId,
            @RequestBody ContactDto dto
    ) {

        return contactService.update(contactId, dto);
    }

    @DeleteMapping("/contacts/{contactId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID contactId
    ) {

        contactService.delete(contactId);
    }

}