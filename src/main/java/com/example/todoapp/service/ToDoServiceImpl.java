package com.example.todoapp.service;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.dto.ResponseDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ToDoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    public ToDoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public ResponseDto saveTodo(RequestDto dto) { //투두 추가하기
        Todo todo = new Todo(dto.getUserName(), dto.getPassword(), dto.getTodo(), dto.getDoDate(), LocalDateTime.now(), LocalDateTime.now()); //투두 내역 받아서
        todoRepository.saveTodo(todo); //레포지토리에 넘겨주자
        return new ResponseDto(todo.getUserName(), dto.getTodo(), dto.getDoDate(), LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public List<ResponseDto> findAllTodo() {
        List<ResponseDto> allTodo = todoRepository.findAllTodo();
        return allTodo;
    }

    @Override
    public ResponseDto findTodoById(Long id) {
        return todoRepository.findOneTodo(id);
    }

    @Override
    public boolean updateTodoById(RequestDto dto) {
        return todoRepository.updateTodoById(dto);
    }

    @Override
    public boolean deleteTodoById(RequestDto dto) {
        return false;
    }


}
