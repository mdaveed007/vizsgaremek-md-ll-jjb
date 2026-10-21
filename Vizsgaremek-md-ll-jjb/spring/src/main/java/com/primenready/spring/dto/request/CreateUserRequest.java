package com.primenready.spring.dto.request;

import jakarta.validation.constraints.*;
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

    @NotNull(message = "Az életkor megadása kötelező")
    @Min(value = 0, message = "Az életkor nem lehet negatív szám")
    @Max(value = 120, message = "Az életkor valósnak kell lennie (maximum 120)")
    private Integer age;
}
