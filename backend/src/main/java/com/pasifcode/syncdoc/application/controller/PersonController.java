package com.pasifcode.syncdoc.application.controller;


import com.pasifcode.syncdoc.domain.dto.PersonDto;
import com.pasifcode.syncdoc.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/office/{officeId}")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto create(
            @PathVariable UUID officeId,
            @RequestBody PersonDto dto
    ) {

        return personService.create(officeId, dto);
    }

    @GetMapping("/{personId}")
    public PersonDto findById(
            @PathVariable UUID personId
    ) {

        return personService.findById(personId);
    }

    @GetMapping("/office/{officeId}")
    public List<PersonDto> findAllByOffice(
            @PathVariable UUID officeId
    ) {

        return personService.findAllByOffice(officeId);
    }

    @PutMapping("/{personId}")
    public PersonDto update(
            @PathVariable UUID personId,
            @RequestBody PersonDto dto
    ) {

        return personService.update(personId, dto);
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID personId
    ) {

        personService.delete(personId);
    }
}
