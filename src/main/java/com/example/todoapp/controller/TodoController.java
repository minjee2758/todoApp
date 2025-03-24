package com.example.todoapp.controller;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.dto.ResponseDto;
import com.example.todoapp.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos") //prefix
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) { //생성자
        this.todoService = todoService;
    }

    @PostMapping //투두 추가하는거니까 Post
    public ResponseDto saveTodo(@RequestBody RequestDto dto){ //추가하라고 요청하기
        return todoService.saveTodo(dto);
    }

    @GetMapping //전체 일정 가져오기
    public List<ResponseDto> findAllTodo(){
        return todoService.findAllTodo();
    }

    @GetMapping("/{id}") //선택 일정 가져오기
    public ResponseDto findTodoById(@PathVariable Long id){
        return todoService.findTodoById(id);
    }

    @PostMapping("/{id}")
    public ResponseDto updateTodoById(@PathVariable Long id){
        return todoService.
    }
}
