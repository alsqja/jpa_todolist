package com.example.jpa_todolist.v2.service.user;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;

import java.util.List;

public interface UserServiceV2 {
    List<CommentResDto> findAllUserComments(Long id);
}
