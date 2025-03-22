package com.example.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.Date;

@Getter
public class RequestDto {
    private String userName; //일정 등록한 사람 이름
    private String password; //비번
    private String todo; //할일 내용
    private Date doDate; //예정 날짜
}
