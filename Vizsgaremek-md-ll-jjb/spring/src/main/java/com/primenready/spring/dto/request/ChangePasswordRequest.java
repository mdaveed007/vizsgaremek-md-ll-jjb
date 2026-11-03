package com.primenready.spring.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {
    private String oldPassword;

    @NotBlank(message = "Az új jelszó megadása kötelező!")
    @Size(min = 6, message = "A jelszó legalább 6 karakter hosszú legyen!")
    private String newPassword;

    @NotBlank(message = "Az új jelszó megerősítése kötelező!")
    private String confirmPassword;
}
