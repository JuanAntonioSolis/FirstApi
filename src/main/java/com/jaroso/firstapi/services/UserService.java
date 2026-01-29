package com.jaroso.firstapi.services;

import com.jaroso.firstapi.dtos.UserCreateDto;
import com.jaroso.firstapi.dtos.UserDto;
import com.jaroso.firstapi.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //RETRIEVE
    List<UserDto> findAll();
    Optional<UserDto> findById(Long id);
    Optional<UserDto> findByUsername(String username);

    //CREATE/UPDATE
    UserDto saveUser(UserCreateDto userDto);

    //DELETE
    void deleteUser(Long id);

    UserDetails loadUserByUsername(String username);

}
