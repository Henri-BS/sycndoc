package com.pasifcode.syncdoc.application.controller;

import com.pasifcode.syncdoc.application.security.AccessToken;
import com.pasifcode.syncdoc.domain.dto.CredentialsDto;
import com.pasifcode.syncdoc.domain.dto.UserRequestDto;
import com.pasifcode.syncdoc.domain.dto.UserResponseDto;
import com.pasifcode.syncdoc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> findAllUsers(
            @RequestParam(defaultValue = "") String username,
            Pageable pageable
    ) {
        Page<UserResponseDto> list = userService.findAll(username, pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable UUID id) {
        UserResponseDto find = userService.findById(id);
        return ResponseEntity.ok(find);
    }

    @PostMapping("/save")
    public void register(@RequestBody UserRequestDto dto) {
        userService.saveUser(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable UUID id, @RequestBody UserRequestDto dto) {
        UserResponseDto update = userService.updateUser(id, dto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AccessToken> login(@RequestBody CredentialsDto credentialsDto) {
        AccessToken token = userService.authenticate(credentialsDto.getEmail(), credentialsDto.getPassword());

        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(token);
    }

}