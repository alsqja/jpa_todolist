package com.example.jpa_todolist.controller.comment;

import com.example.jpa_todolist.dto.comment.CommentResDto;
import com.example.jpa_todolist.dto.comment.CreateCommentReqDto;
import com.example.jpa_todolist.dto.comment.UpdateCommentReqDto;
import com.example.jpa_todolist.dto.user.UserResDto;
import com.example.jpa_todolist.service.comment.CommentService;
import com.example.jpa_todolist.session.Const;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentResDto> save(
            @Valid @RequestBody CreateCommentReqDto dto,
            @SessionAttribute(name = Const.LOGIN_USER) UserResDto user
    ) {

        return new ResponseEntity<>(commentService.save(user.getId(), dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentResDto> updateComment(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCommentReqDto dto,
            @SessionAttribute(name = Const.LOGIN_USER) UserResDto user
    ) {
        return new ResponseEntity<>(commentService.update(id, user.getId(), dto), HttpStatus.OK);
    }
}
