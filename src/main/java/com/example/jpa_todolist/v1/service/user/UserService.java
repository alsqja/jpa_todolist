package com.example.jpa_todolist.v1.service.user;

import com.example.jpa_todolist.v1.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.v1.dto.user.LoginReqDto;
import com.example.jpa_todolist.v1.dto.user.UserResDto;

public interface UserService {
    UserResDto signUp(CreateUserReqDto dto);

    UserResDto login(LoginReqDto dto);

    void delete(Long id);
}
