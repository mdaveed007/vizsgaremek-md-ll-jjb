package com.primenready.spring.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotBlank(message = "A felhasználónév megadása kötelező")
    @Size(max = 50)
    private String username;

    @NotBlank(message = "A email megadása kötelező")
    @Email(message = "Nem érvényes email formátum")
    private String email;

    @NotBlank(message = "A jelszó megadása kötelező")
    @Size(min = 6, message = "A jelszó legalább 6 karakter hosszú")
    private String password;

}
