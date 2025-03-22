package com.example.todoapp.repository;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.dto.ResponseDto;

public interface TodoRepository {
    void saveTodo(Todo todo);
}
