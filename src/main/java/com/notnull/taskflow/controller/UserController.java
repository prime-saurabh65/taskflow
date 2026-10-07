package com.notnull.taskflow.controller;

import com.notnull.taskflow.dto.UserRequest;
import com.notnull.taskflow.dto.UserResponse;
import com.notnull.taskflow.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.notnull.taskflow.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {

        UserResponse userResponse = userService.createUser(userRequest);

        return ResponseEntity.ok(userResponse);

    }

}
