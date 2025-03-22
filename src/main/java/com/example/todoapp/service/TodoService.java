package com.example.todoapp.service;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.dto.ResponseDto;

public interface TodoService {
    ResponseDto addTodo(RequestDto dto);
}
