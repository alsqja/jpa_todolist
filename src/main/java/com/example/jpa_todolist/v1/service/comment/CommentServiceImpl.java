package com.example.jpa_todolist.v1.service.comment;

import com.example.jpa_todolist.v1.dto.comment.CommentResDto;
import com.example.jpa_todolist.v1.dto.comment.CreateCommentReqDto;
import com.example.jpa_todolist.v1.dto.comment.UpdateCommentReqDto;
import com.example.jpa_todolist.v1.entity.comment.Comment;
import com.example.jpa_todolist.v1.entity.todo.Todo;
import com.example.jpa_todolist.v1.entity.user.User;
import com.example.jpa_todolist.v1.repository.comment.CommentRepository;
import com.example.jpa_todolist.v1.repository.todo.TodoRepository;
import com.example.jpa_todolist.v1.repository.user.UserRepository;
import com.example.jpa_todolist.v1.service.common.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentServiceImpl extends AbstractBaseService<Comment, CommentResDto> implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, TodoRepository todoRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @Override
    protected CommentResDto toResponseDto(Comment comment) {
        return new CommentResDto(comment); // DTO 변환 로직
    }

    @Override
    public CommentResDto save(Long userId, CreateCommentReqDto dto) {
        User user = userRepository.findByIdOrElseThrow(userId);
        Todo todo = todoRepository.findByIdOrElseThrow(dto.getTodoId());

        Comment comment = new Comment(dto.getContents());
        comment.setTodo(todo);
        comment.setUser(user);

        return toResponseDto(commentRepository.save(comment));
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

        return toResponseDto(comment);
    }

    @Override
    public void delete(Long id, Long userId) {
        User user = userRepository.findByIdOrElseThrow(userId);

        Comment comment = commentRepository.findByIdOrElseThrow(id);

        if (!comment.getUser().getId().equals(user.getId())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid user");
        }

        commentRepository.delete(comment);
    }
}
