package com.pasifcode.cma_docs.application.controller;

import com.pasifcode.cma_docs.domain.dto.PoaDto;
import com.pasifcode.cma_docs.service.PoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poas")
public class PoaController {

    private final PoaService poaService;

    @Autowired
    public PoaController(PoaService poaService) {
        this.poaService = poaService;
    }

    @GetMapping
    public ResponseEntity<Page<PoaDto>> findAll(Pageable pageable) {
        Page<PoaDto> list = poaService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PoaDto> findById(@PathVariable Long id) {
        PoaDto find = poaService.findById(id);
        return ResponseEntity.ok(find);
    }


}
