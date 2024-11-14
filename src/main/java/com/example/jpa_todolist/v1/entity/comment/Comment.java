package com.example.jpa_todolist.v1.entity.comment;

import com.example.jpa_todolist.v1.entity.BaseEntity;
import com.example.jpa_todolist.v1.entity.todo.Todo;
import com.example.jpa_todolist.v1.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comment")
@Getter
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Setter
    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    public Comment(String contents) {
        this.contents = contents;
    }

    public Comment() {
        
    }
}
