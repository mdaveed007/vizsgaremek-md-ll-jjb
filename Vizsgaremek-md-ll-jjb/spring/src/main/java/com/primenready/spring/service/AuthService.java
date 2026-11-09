package com.primenready.spring.service;

import com.primenready.spring.dto.request.LoginRequest;
import com.primenready.spring.dto.response.AuthResponse;
import com.primenready.spring.exception.IncorrectPasswordException;
import com.primenready.spring.model.User;
import com.primenready.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsernameOrEmail(request.getUsernameOrEmail(), request.getUsernameOrEmail())
                .orElseThrow(() -> new IncorrectPasswordException("Hibás felhasználó név vagy jelszó!"));

        if (user.getIsDeleted()) {
            throw new IncorrectPasswordException("A fiók jelenleg inaktív vagy törölve lett.");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IncorrectPasswordException("Hibás jelszó vagy felhasználó név");
        }

        String mockToken = "mock-jwt-token-teszteleshez";

        return AuthResponse.builder()
                .token(mockToken)
                .tokenType("Bearer")
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
