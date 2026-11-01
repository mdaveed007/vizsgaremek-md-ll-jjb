package com.primenready.spring.service;

import com.primenready.spring.dto.request.CreateUserRequest;
import com.primenready.spring.dto.response.UserResponse;
import com.primenready.spring.model.Role;
import com.primenready.spring.model.User;
import com.primenready.spring.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse createUser(CreateUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())){
            throw new IllegalStateException("Ez az email cím már foglalt: " + request.getEmail());
        }

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .age(request.getAge())
                .role(Role.USER)
                .isDeleted(false)
                .build();

        User saved = userRepository.save(user);

        return UserResponse.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .email(saved.getEmail())
                .role(saved.getRole())
                .build();
    }

    public UserResponse toResponseDto(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .age(user.getAge())
                .role(user.getRole())
                .build();
    }

    public List<UserResponse> getAllActive() {
        return userRepository.findAllActive().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public UserResponse getActiveById(Integer id) {
        User user = userRepository.findActiveById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nincs ilyen felhasználó: " + id));
        return toResponseDto(user);
    }
}
