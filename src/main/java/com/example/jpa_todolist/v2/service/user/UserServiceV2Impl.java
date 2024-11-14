package com.example.jpa_todolist.v2.service.user;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;
import com.example.jpa_todolist.v2.repository.comment.CommentRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceV2Impl implements UserServiceV2 {

    private final CommentRepositoryV2 commentRepositoryV2;

    @Override
    public List<CommentResDto> findAllUserComments(Long id) {
        return commentRepositoryV2.findByUserIdOrderByUpdatedAtDesc(id).stream().map(CommentResDto::new).toList();
    }
}
