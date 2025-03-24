package com.example.todoapp.repository;

import com.example.todoapp.entity.Todo;
import com.example.todoapp.dto.ResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;



@Repository
public class JdbcTemplateTodoRepository implements TodoRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void saveTodo(Todo todo) {
        String sql = "INSERT INTO todo (userName, password, todo, doDate, createDate, updateDate) VALUES (?,?,?,?,?,?) "; //위에꺼랑 여기꺼랑 뭐가 더 좋은 방법일지?? -> 위에는 강의대로!
        jdbcTemplate.update(sql, todo.getUserName(), todo.getPassword(), todo.getTodo(),todo.getDoDate(), todo.getCreateDate(), todo.getUpdateDate());
    }


}
