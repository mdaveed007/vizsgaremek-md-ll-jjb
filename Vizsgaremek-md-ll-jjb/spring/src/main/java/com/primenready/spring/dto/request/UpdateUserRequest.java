package com.primenready.spring.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @Size(max = 50)
    private String username;

    @Email(message = "Nem érvényes email formátum")
    private String email;

    @Min(value = 0, message = "Az életkor nem lehet negatív szám")
    @Max(value = 120, message = "Az életkornak valósnak kell lennie (maximum 120)")
    private Integer age;
}
