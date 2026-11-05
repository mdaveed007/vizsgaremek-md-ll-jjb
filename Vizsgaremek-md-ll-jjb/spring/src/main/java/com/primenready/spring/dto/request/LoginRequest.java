package com.primenready.spring.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "A felhasználó név vagy email cím megadása kötelező!")
    private String usernameOrEmail;

    @NotBlank(message = "A jelszó megadása kötelező")
    private String password;
}
