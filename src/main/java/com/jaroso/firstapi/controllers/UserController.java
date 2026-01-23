package com.jaroso.firstapi.controllers;

import com.jaroso.firstapi.dtos.UserCreateDto;
import com.jaroso.firstapi.dtos.UserDto;
import com.jaroso.firstapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUsersByUsername(@PathVariable String username) {
        return userService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserCreateDto user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

}
