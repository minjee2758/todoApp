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
        String sql = "INSERT INTO todo (userName, password, todo, doDate) VALUES (?,?,?,?) ";
        jdbcTemplate.update(sql, todo.getUserName(), todo.getPassword(), todo.getTodo(),todo.getDoDate());
    }
}
