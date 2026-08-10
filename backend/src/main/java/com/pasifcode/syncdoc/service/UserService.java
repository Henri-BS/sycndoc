package com.pasifcode.syncdoc.service;

import com.pasifcode.syncdoc.application.security.AccessToken;
import com.pasifcode.syncdoc.domain.dto.UserRequestDto;
import com.pasifcode.syncdoc.domain.dto.UserResponseDto;
import com.pasifcode.syncdoc.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {
    User findUserByEmail(String email);

    Page<UserResponseDto> findAll(String username, Pageable pageable);

    UserResponseDto findById(UUID id);

    void saveUser(UserRequestDto dto);

    UserResponseDto updateUser(UUID id, UserRequestDto dto);

    AccessToken authenticate(String email, String password);


}
