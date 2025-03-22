package com.example.todoapp.controller;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.dto.ResponseDto;
import com.example.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos") //prefix
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) { //생성자
        this.todoService = todoService;
    }

    @PostMapping //투두 추가하는거니까 Post
    public ResponseDto addTodo(@RequestBody RequestDto dto){ //추가하라고 요청하기
        return todoService.addTodo(dto);
    }
}
