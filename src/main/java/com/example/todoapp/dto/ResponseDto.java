package com.example.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ResponseDto {
    private String userName; //일정 등록한 사람 이름
    private String todo; //할일 내용
    private Date doDate; //예정 날짜
}
