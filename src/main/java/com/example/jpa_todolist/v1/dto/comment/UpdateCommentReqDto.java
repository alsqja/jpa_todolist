package com.example.jpa_todolist.v1.dto.comment;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateCommentReqDto {

    @NotNull(message = "contents is required")
    private final String contents;

    //  requestBody mapping 오류 발생 -> JsonCreator 해결
    //  왜 발생한 오류?
    //  JsonCreator 사용 x -> 기본 생성자 필요
    //  RequestBody -> String 으로 하나만 받기 가능
    @JsonCreator
    public UpdateCommentReqDto(String contents) {
        this.contents = contents;
    }
}
