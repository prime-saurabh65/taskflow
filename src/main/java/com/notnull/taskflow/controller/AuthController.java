package com.notnull.taskflow.controller;

import com.notnull.taskflow.dto.LoginRequest;
import com.notnull.taskflow.dto.LoginResponse;
import com.notnull.taskflow.dto.UserRequest;
import com.notnull.taskflow.dto.UserResponse;
import com.notnull.taskflow.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> resgister(@Valid @RequestBody UserRequest userRequest){
        return ResponseEntity.ok(
                userService.createUser(userRequest)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){

        return ResponseEntity.ok(userService.login(loginRequest));
    }


}
