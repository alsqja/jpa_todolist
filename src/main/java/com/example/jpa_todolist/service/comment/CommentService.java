package com.example.jpa_todolist.service.comment;

import com.example.jpa_todolist.dto.comment.CommentResDto;
import com.example.jpa_todolist.dto.comment.CreateCommentReqDto;

public interface CommentService {
    CommentResDto save(Long userId, CreateCommentReqDto dto);

    CommentResDto findById(Long id);
}
