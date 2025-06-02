package com.pasifcode.cma_docs.service.impl;

import com.pasifcode.cma_docs.application.exception.DuplicateTuplesException;
import com.pasifcode.cma_docs.application.security.AccessToken;
import com.pasifcode.cma_docs.application.security.JwtHelper;
import com.pasifcode.cma_docs.domain.dto.UserDto;
import com.pasifcode.cma_docs.domain.entity.User;
import com.pasifcode.cma_docs.domain.repository.UserRepository;
import com.pasifcode.cma_docs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtHelper jwtHelper;

    @Lazy
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, JwtHelper jwtHelper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtHelper = jwtHelper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Page<UserDto> findAll(Pageable pageable) {
        Page<User> list = userRepository.findAll(pageable);
        return list.map(UserDto::new);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        User find = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return new UserDto(find);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(UserDto dto) {

        User add = new User();
        add.setEmail(dto.getEmail());
        add.setUsername(dto.getUsername());
        add.setPassword(passwordEncoder.encode(dto.getPassword()));
        add.setUserRoles(dto.getUserRoles());
        var getEmail = findByEmail(add.getEmail());
        if (getEmail != null) {
            throw new DuplicateTuplesException("Usuário já existe!");
        }
        new UserDto(userRepository.save(add));
    }

    @Override
    public AccessToken authenticate(String email, String password) {
        var user = findByEmail(email);
        if (user == null) {
            return null;
        }

        boolean matches = passwordEncoder.matches(password, user.getPassword());
        if(matches){
            return jwtHelper.generateToken(user);
        }
        return null;
    }

    @Override
    public UserDto updateUser(UserDto dto) {
        User edit = userRepository.findById(dto.getId()).orElseThrow();
        edit.setId(edit.getId());
        edit.setUsername(dto.getUsername());
        edit.setImage(dto.getUserImage());
        edit.setCoverImage(dto.getUserCoverImage());
        edit.setUserBio(dto.getUserBio());
        edit.setUserLocation(dto.getUserLocation());
        edit.setPassword(passwordEncoder.encode(dto.getPassword()));

        return new UserDto(userRepository.save(edit));
    }
}
