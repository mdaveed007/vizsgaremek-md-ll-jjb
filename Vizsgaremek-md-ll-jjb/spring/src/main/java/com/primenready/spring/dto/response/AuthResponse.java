package com.primenready.spring.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;
    private String tokenType;
    private String username;
    private String email;
    private String role;
}
