package com.example.todoapp.service;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.dto.ResponseDto;

import java.util.List;

public interface TodoService {
    ResponseDto saveTodo(RequestDto dto);
    List<ResponseDto> findAllTodo();
    ResponseDto findTodoById(Long id);
    RequestDto updateTodoById(Long id);
}
