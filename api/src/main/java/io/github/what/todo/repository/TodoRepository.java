package io.github.what.todo.repository;

import io.github.what.todo.annotation.Generated;
import io.github.what.todo.entity.Todo;
import io.github.what.todo.entity.User;
import io.github.what.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

@Generated
@Repository
public class TodoRepository {

    @Autowired
    private UserService userService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> getTodoCollectionForUser(User user) {
        return jdbcTemplate.query("SELECT * FROM tdtd_todo WHERE USER_ID = ?", this::mapTodo, user.getId());
    }

    public void saveTodo(Todo todo) {
        jdbcTemplate.update("INSERT INTO tdtd_todo (USER_ID, TODO_TASK) VALUES ( ?, ? )", todo.getUser().getId(), todo.getTask());
    }

    public void updateTodo(Todo todo) {
        jdbcTemplate.update("UPDATE tdtd_todo SET USER_ID = ?, TODO_TASK = ?, TODO_LAST_UPDATED = ?, TODO_IS_COMPLETED = ? WHERE TODO_ID = ?", todo.getUser().getId(), todo.getTask(), todo.getLastUpdatedDate(), todo.isCompleted(), todo.getId());
    }

    public void deleteTodo(Todo todo) {
        jdbcTemplate.update("UPDATE tdtd_todo SET TODO_IS_DELETED = ? WHERE USER_ID = ?", todo.isDeleted(), todo.getId());
    }

    private Todo mapTodo(ResultSet rs, int rowNum) throws SQLException {
        return new Todo(
                rs.getLong("TODO_ID"),
                new User(rs.getLong("USER_ID"), "", "", "", "", new Date(12345L)),
                rs.getString("TODO_TASK"),
                this.getLocalDateTimeFromString(rs.getString("TODO_LAST_UPDATED")),
                rs.getBoolean("TODO_IS_COMPLETED"),
                rs.getBoolean("TODO_IS_DELETED")
        );
    }

    private LocalDateTime getLocalDateTimeFromString(String date) {
        date = date.replaceFirst("\\.\\d+", "");
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}