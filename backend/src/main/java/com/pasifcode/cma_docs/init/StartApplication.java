package com.pasifcode.cma_docs.init;

import com.pasifcode.cma_docs.domain.entity.User;
import com.pasifcode.cma_docs.domain.enums.UserRoles;
import com.pasifcode.cma_docs.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    @Lazy
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public StartApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("Henrique B. Santos");
        user.setEmail("hbsantos720@gmail.com");
        user.setPassword(passwordEncoder.encode("12345678"));
        user.setUserRoles(UserRoles.ADMIN);
        userRepository.save(user);
    }
}