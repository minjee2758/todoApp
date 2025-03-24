package com.example.todoapp.service;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.dto.ResponseDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class ToDoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public ToDoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public ResponseDto addTodo(RequestDto dto) { //투두 추가하기
        Todo todo = new Todo(dto.getUserName(), dto.getPassword(), dto.getTodo(), dto.getDoDate(), LocalDateTime.now(), LocalDateTime.now()); //투두 내역 받아서
        todoRepository.saveTodo(todo); //레포지토리에 넘겨주자
        return new ResponseDto(todo.getUserName(), dto.getTodo(), dto.getDoDate(), LocalDateTime.now(), LocalDateTime.now());
    }
}
