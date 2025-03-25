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
        Todo todo = new Todo(dto.getId(), dto.getUserName(), dto.getPassword(), dto.getTodo(), dto.getDoDate(), LocalDateTime.now(), LocalDateTime.now()); //투두 내역 받아서
        todoRepository.saveTodo(todo); //레포지토리에 넘겨주자
        return new ResponseDto(todo.getId(), todo.getUserName(), dto.getTodo(), dto.getDoDate(), LocalDateTime.now(), LocalDateTime.now());
    }

    @Override
    public List<ResponseDto> findAllTodo() { //전체 리스트 뽑기
        List<ResponseDto> allTodo = todoRepository.findAllTodo();
        return allTodo;
    }

    @Override
    public ResponseDto findTodoById(Long id) { //단건 조회하기
        return todoRepository.findOneTodo(id);
    }

    @Override
    public boolean updateTodoById(RequestDto dto) { //원하는 id의 행 수정하기
        return todoRepository.updateTodoById(dto);
    }

    @Override
    public boolean deleteTodoById(RequestDto dto) { //삭제하기
        return todoRepository.deleteTodoById(dto);
    }


}
