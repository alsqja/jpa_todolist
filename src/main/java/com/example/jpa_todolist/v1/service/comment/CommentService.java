package com.example.jpa_todolist.v1.service.comment;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;
import com.example.jpa_todolist.v1.dto.comment.CreateCommentReqDto;
import com.example.jpa_todolist.v1.dto.comment.UpdateCommentReqDto;

public interface CommentService {
    CommentResDto save(Long userId, CreateCommentReqDto dto);

    CommentResDto findById(Long id);

    CommentResDto update(Long id, Long userId, UpdateCommentReqDto dto);

    void delete(Long id, Long userId);
}
