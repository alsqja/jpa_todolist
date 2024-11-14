package com.example.jpa_todolist.v1.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateUserReqDto {

    @NotNull(message = "name is required")
    private final String name;

    @NotNull(message = "email is required")
    @Email(message = "enter in email format")
    private final String email;

    @NotNull(message = "password is required")
    private final String password;

    public CreateUserReqDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
