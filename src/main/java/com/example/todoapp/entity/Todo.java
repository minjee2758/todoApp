package com.example.todoapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class Todo {

    private Long id;
    private String userName; //일정 등록한 사람 이름
    private String password; //비번
    private String todo; //할일 내용

    @JsonFormat(pattern = "YYYY-MM-DD")
    private Date doDate; //예정 날짜

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
