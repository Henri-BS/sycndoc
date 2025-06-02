package com.pasifcode.cma_docs.service;

import com.pasifcode.cma_docs.application.security.AccessToken;
import com.pasifcode.cma_docs.domain.dto.UserDto;
import com.pasifcode.cma_docs.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<UserDto> findAll(Pageable pageable);

    UserDto findById(Long id);

    User findByEmail(String email);

    void saveUser(UserDto dto);

    AccessToken authenticate(String email, String password);

    UserDto updateUser(UserDto dto);

}
