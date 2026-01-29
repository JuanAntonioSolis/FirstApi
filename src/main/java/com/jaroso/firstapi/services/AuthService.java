package com.jaroso.firstapi.services;

import com.jaroso.firstapi.dtos.AuthDto;
import com.jaroso.firstapi.dtos.UserCreateDto;
import com.jaroso.firstapi.entities.User;
import com.jaroso.firstapi.repositories.UserRepository;
import com.jaroso.firstapi.security.PasswordConfig;
import com.jaroso.firstapi.security.UserAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthDto save(UserCreateDto userDTO) {
        User user = new User(
                null,
                userDTO.username(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.email(),
                List.of(UserAuthority.READ)
        );

        this.userRepository.save(user);

        return null;
    }

}
