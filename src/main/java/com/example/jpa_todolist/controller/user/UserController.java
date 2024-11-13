package com.example.jpa_todolist.controller.user;

import com.example.jpa_todolist.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.dto.user.UserResDto;
import com.example.jpa_todolist.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResDto> signUp(@Valid @RequestBody CreateUserReqDto dto) {
        return new ResponseEntity<>(userService.signUp(dto), HttpStatus.CREATED);
    }
}
