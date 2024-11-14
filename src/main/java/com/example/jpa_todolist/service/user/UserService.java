package com.example.jpa_todolist.service.user;

import com.example.jpa_todolist.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.dto.user.LoginReqDto;
import com.example.jpa_todolist.dto.user.UserResDto;

public interface UserService {
    UserResDto signUp(CreateUserReqDto dto);

    UserResDto login(LoginReqDto dto);
}
