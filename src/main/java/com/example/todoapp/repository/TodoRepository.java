package com.example.todoapp.repository;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.dto.ResponseDto;

import java.util.List;

public interface TodoRepository {
    void saveTodo(Todo todo);
    List<ResponseDto> findAllTodo();
    ResponseDto findOneTodo(Long todo);
    boolean updateTodoById(RequestDto dto);
    boolean deleteTodoById(RequestDto dto);
}
