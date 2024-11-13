package com.example.jpa_todolist.service.user;

import com.example.jpa_todolist.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.dto.user.UserResDto;
import jakarta.validation.Valid;

public interface UserService {
    UserResDto signUp(@Valid CreateUserReqDto dto);
}
