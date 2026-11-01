package com.primenready.spring.controller;

import com.primenready.spring.dto.request.CreateUserRequest;
import com.primenready.spring.dto.response.UserResponse;
import com.primenready.spring.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse response = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getActiveById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getActiveById(id));
    }
}
