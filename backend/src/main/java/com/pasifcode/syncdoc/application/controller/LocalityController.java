package com.pasifcode.syncdoc.application.controller;

import com.pasifcode.syncdoc.domain.dto.LocalityDto;
import com.pasifcode.syncdoc.service.LocalityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LocalityController {

    private final LocalityService localityService;

    @PostMapping("/offices/{officeId}/localities")
    public LocalityDto create(
            @PathVariable UUID officeId,
            @RequestBody LocalityDto dto){

        return localityService.create(officeId,dto);

    }

    @GetMapping("/offices/{officeId}/localities")
    public List<LocalityDto> findAll(
            @PathVariable UUID officeId){

        return localityService.findAllByOfficeId(officeId);

    }

    @GetMapping("/localities/{id}")
    public LocalityDto findById(
            @PathVariable UUID id){

        return localityService.findById(id);

    }

}