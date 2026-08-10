package com.pasifcode.syncdoc.service.impl;


import com.pasifcode.syncdoc.application.exception.DuplicateTuplesException;
import com.pasifcode.syncdoc.application.mapper.UserMapper;
import com.pasifcode.syncdoc.application.security.AccessToken;
import com.pasifcode.syncdoc.application.security.JwtHelper;
import com.pasifcode.syncdoc.domain.dto.UserRequestDto;
import com.pasifcode.syncdoc.domain.dto.UserResponseDto;
import com.pasifcode.syncdoc.domain.entity.User;
import com.pasifcode.syncdoc.domain.repository.UserRepository;
import com.pasifcode.syncdoc.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;

    @Override
    @Transactional
    public void saveUser(UserRequestDto dto) {
        User user = userMapper.toEntity(dto);
        var possibleUser = findUserByEmail(user.getEmail());
        if (possibleUser != null) {
            throw new DuplicateTuplesException("Usuário já existe!");
        }
        encodePassword(user);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public UserResponseDto updateUser(UUID id, UserRequestDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        if(StringUtils.hasText(dto.getUsername())) {
            user.setUsername(dto.getUsername());
        }

        if(StringUtils.hasText(dto.getEmail())) {
            user.setEmail(dto.getEmail());
        }

        if (dto.getUserRoles() != null) {
            user.setUserRoles(dto.getUserRoles());
        }

        if (StringUtils.hasText(dto.getUserBio())){
            user.setUserBio(dto.getUserBio());
        }

        if (StringUtils.hasText(dto.getProfileImage())) {
            user.setProfileImage(dto.getProfileImage());
        }

        if (StringUtils.hasText(dto.getCoverImage())) {
            user.setCoverImage(dto.getCoverImage());
        }

        if (StringUtils.hasText(dto.getPassword())) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        User saved = userRepository.save(user);

        return userMapper.toResponseDto(saved);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Page<UserResponseDto> findAll(String username, Pageable pageable) {
        Specification<User> spec = Specification.allOf();

        if(StringUtils.hasText(username)) {
            spec = spec.and((root, query, cb) ->
                    cb.like(cb.upper(root.get("username")), "%" + username.toUpperCase() + "%"));

        }

        return userRepository.findAll(spec, pageable)
                .map(userMapper::toResponseDto);
    }

    @Override
    public UserResponseDto findById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));
        return userMapper.toResponseDto(user);
    }


    @Override
    public AccessToken authenticate(String email, String password) {
        var user = findUserByEmail(email);
        if (user == null) {
            return null;
        }

        boolean matches = passwordEncoder.matches(password, user.getPassword());
        return matches ? jwtHelper.generateToken(user) : null;
    }


    private void encodePassword(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
    }
}
