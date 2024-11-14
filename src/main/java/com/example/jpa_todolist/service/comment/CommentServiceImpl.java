package com.example.jpa_todolist.service.comment;

import com.example.jpa_todolist.dto.comment.CommentResDto;
import com.example.jpa_todolist.dto.comment.CreateCommentReqDto;
import com.example.jpa_todolist.dto.comment.UpdateCommentReqDto;
import com.example.jpa_todolist.entity.comment.Comment;
import com.example.jpa_todolist.entity.todo.Todo;
import com.example.jpa_todolist.entity.user.User;
import com.example.jpa_todolist.repository.comment.CommentRepository;
import com.example.jpa_todolist.repository.todo.TodoRepository;
import com.example.jpa_todolist.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Override
    public CommentResDto save(Long userId, CreateCommentReqDto dto) {
        User user = userRepository.findByIdOrElseThrow(userId);
        Todo todo = todoRepository.findByIdOrElseThrow(dto.getTodoId());

        Comment comment = new Comment(dto.getContents());
        comment.setTodo(todo);
        comment.setUser(user);

        return new CommentResDto(commentRepository.save(comment));
    }

    @Override
    public CommentResDto findById(Long id) {
        return new CommentResDto(commentRepository.findByIdOrElseThrow(id));
    }

    @Transactional
    @Override
    public CommentResDto update(Long id, Long userId, UpdateCommentReqDto dto) {
        User user = userRepository.findByIdOrElseThrow(userId);

        Comment comment = commentRepository.findByIdOrElseThrow(id);

        if (!comment.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid user");
        }

        comment.setContents(dto.getContents());

        return new CommentResDto(comment);
    }
}
