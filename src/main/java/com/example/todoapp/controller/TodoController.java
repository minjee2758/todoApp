package com.example.todoapp.controller;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.dto.ResponseDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<ResponseDto> saveTodo(@RequestBody RequestDto dto){ //추가하라고 요청하기
        ResponseDto responseDto = todoService.saveTodo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @GetMapping //전체 일정 가져오기
    public ResponseEntity<List<ResponseDto>> findAllTodo(){
        List<ResponseDto> responseDtoList = todoService.findAllTodo();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDtoList);
    }

    @GetMapping("/{id}") //선택 일정 가져오기
    public ResponseEntity<ResponseDto> findTodoById(@PathVariable Long id){
        ResponseDto responseDto = todoService.findTodoById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseDto);
    }

    //수정
    @PutMapping("/update")
    public ResponseEntity<String> updateTodoById(@RequestBody RequestDto dto){
        boolean isUpdated = todoService.updateTodoById(dto);
        if (isUpdated){
            return ResponseEntity.ok("업뎃 됨!"); //문구 표시
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 업뎃입니다");
        }
    }

    //삭제
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTodoById(@RequestBody RequestDto dto){
        boolean isDeleted = todoService.deleteTodoById(dto);
        if (isDeleted){
            return ResponseEntity.ok("정상 삭제됨");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("잘못된 삭제 접근입니다");
        }
    }
}
