package com.pasifcode.cma_docs.application.controller;

import com.pasifcode.cma_docs.application.exception.DuplicateTuplesException;
import com.pasifcode.cma_docs.domain.dto.ClienteDto;
import com.pasifcode.cma_docs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDto>> findAll(Pageable pageable) {
        Page<ClienteDto> list = clienteService.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        ClienteDto find = clienteService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> saveCliente(@RequestBody ClienteDto dto) {
        try {
            clienteService.saveCliente(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (DuplicateTuplesException e) {
            Map<String, String> jsonResult = Map.of("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(jsonResult);
        }
    }
}
