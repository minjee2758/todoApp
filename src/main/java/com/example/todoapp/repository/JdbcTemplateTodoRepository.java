package com.example.todoapp.repository;

import com.example.todoapp.dto.RequestDto;
import com.example.todoapp.entity.Todo;
import com.example.todoapp.dto.ResponseDto;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public class JdbcTemplateTodoRepository implements TodoRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTodoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //저장하기
    @Override
    public void saveTodo(Todo todo) {
        String sql = "INSERT INTO todo (userName, password, todo, doDate, createDate, updateDate) VALUES (?,?,?,?,?,?) ";
        jdbcTemplate.update(sql, todo.getUserName(), todo.getPassword(), todo.getTodo(),todo.getDoDate(), todo.getCreateDate(), todo.getUpdateDate());
    }

    //전체 조회하기
    @Override
    public List<ResponseDto> findAllTodo() {
        String sql = "SELECT id, userName, todo, doDate, createDate, updateDate FROM todo ORDER BY updateDate Desc ";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new ResponseDto(
                        rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("todo"),
                        rs.getDate("doDate"),
                        rs.getTimestamp("createDate").toLocalDateTime(),
                        rs.getTimestamp("updateDate").toLocalDateTime()
                )
        );
    }

    //단건 조회하기
    @Override
    public ResponseDto findOneTodo(Long id){
        String sql = "SELECT * FROM todo WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new ResponseDto(
                        rs.getLong("id"),
                        rs.getString("userName"),
                        rs.getString("todo"),
                        rs.getDate("doDate"),
                        rs.getTimestamp("createDate").toLocalDateTime(),
                        rs.getTimestamp("updateDate").toLocalDateTime()
                ), id
        );
    }

    //비밀번호 맞으면 수정하기
    @Override
    public boolean updateTodoById(RequestDto dto) {
        String findPW = "SELECT password FROM todo WHERE id = ?";
        String Pw = jdbcTemplate.queryForObject(findPW, new Object[]{dto.getId()}, String.class);
        if (!dto.getPassword().equals(Pw)) {
            System.out.println("잘못된 비번");
            return false;
        } else {
            String updateTodo = "UPDATE todo SET userName = ?, todo =? , updateDate = ? WHERE id= ?";
            jdbcTemplate.update(updateTodo, dto.getUserName(), dto.getTodo(), LocalDateTime.now(),dto.getId());
            return true;
        }
    }

    //비밀번호 맞으면 삭제하기
    @Override
    public boolean deleteTodoById(RequestDto dto) {
        String findPw = "SELECT password FROM todo WHERE id =?";
        String Pw = jdbcTemplate.queryForObject(findPw, new Object[]{dto.getId()}, String.class);
        if (!dto.getPassword().equals(Pw)) {
            return false;
        } else {
            if (dto.getId() != null) {
                String sql = "DELETE FROM todo WHERE id = ?";
                jdbcTemplate.update(sql, dto.getId());
                return true;
            } else {
                return false;
            }
        }
    }


}
