package com.example.jpa_todolist.v1.controller.user;

import com.example.jpa_todolist.v1.dto.user.CreateUserReqDto;
import com.example.jpa_todolist.v1.dto.user.LoginReqDto;
import com.example.jpa_todolist.v1.dto.user.UserResDto;
import com.example.jpa_todolist.v1.service.user.UserService;
import com.example.jpa_todolist.v1.session.Const;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")

public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResDto> signUp(@Valid @RequestBody CreateUserReqDto dto) {
        return new ResponseEntity<>(userService.signUp(dto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(
            @Valid @RequestBody LoginReqDto dto,
            HttpServletRequest request
    ) {
        UserResDto findUser = userService.login(dto);

        HttpSession session = request.getSession();

        session.setAttribute(Const.LOGIN_USER, findUser);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@SessionAttribute(name = Const.LOGIN_USER) UserResDto user) {

        userService.delete(user.getId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }
}
