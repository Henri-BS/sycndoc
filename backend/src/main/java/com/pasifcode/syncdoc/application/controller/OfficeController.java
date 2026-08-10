package com.pasifcode.syncdoc.application.controller;

import com.pasifcode.syncdoc.domain.dto.OfficeDto;
import com.pasifcode.syncdoc.service.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfficeDto create(
            @RequestBody OfficeDto dto
    ) {
        return officeService.create(dto);
    }

    @GetMapping("/{officeId}")
    public OfficeDto findById(
            @PathVariable UUID officeId
    ) {

        return officeService.findById(officeId);
    }

    @GetMapping
    public List<OfficeDto> findAll() {

        return officeService.findAll();
    }

    @PutMapping("/{officeId}")
    public OfficeDto update(
            @PathVariable UUID officeId,
            @RequestBody OfficeDto dto
    ) {

        return officeService.update(officeId, dto);
    }

    @DeleteMapping("/{officeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable UUID officeId
    ) {

        officeService.delete(officeId);
    }
}
