package com.example.jpa_todolist.v2.controller.user;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;
import com.example.jpa_todolist.v2.service.user.UserServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v2/users")
@RequiredArgsConstructor
public class UserControllerV2 {

    private final UserServiceV2 userServiceV2;

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentResDto>> findAllUserComments(@PathVariable Long id) {
        return new ResponseEntity<>(userServiceV2.findAllUserComments(id), HttpStatus.OK);
    }
}
