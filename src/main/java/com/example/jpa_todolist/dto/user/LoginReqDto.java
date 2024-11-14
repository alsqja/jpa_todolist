package com.example.jpa_todolist.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginReqDto {

    @NotNull(message = "email is required")
    @Email(message = "enter in email format")
    private final String email;

    @NotNull(message = "password is required")
    private final String password;

    public LoginReqDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
