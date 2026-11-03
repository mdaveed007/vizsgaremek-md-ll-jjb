package com.primenready.spring.controller;

import com.primenready.spring.dto.request.ChangePasswordRequest;
import com.primenready.spring.dto.request.CreateUserRequest;
import com.primenready.spring.dto.request.UpdateUserRequest;
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
    public ResponseEntity<List<UserResponse>> getAllActive() {
        return ResponseEntity.ok(userService.getAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getActiveById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getActiveById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer id, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping
    public ResponseEntity<Void> softDelete(@PathVariable Integer id) {
        userService.softDelete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> changePassword(@PathVariable Integer id, @RequestBody ChangePasswordRequest request) {
        userService.changePassword(id, request);
        return ResponseEntity.noContent().build();
    }
}
