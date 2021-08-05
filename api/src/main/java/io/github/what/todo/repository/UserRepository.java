package io.github.what.todo.repository;

import io.github.what.todo.annotation.Generated;
import io.github.what.todo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Generated
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM tdtd_users WHERE user_id = ?", this::mapUser, id);
    }

    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO tdtd_users (USER_USERNAME, USER_NAME, USER_SURNAME, USER_EMAIL, USER_DOB, USER_PASSWORD) VALUES ( ?, ?, ?, ?, ?, ? )", user.getUsername(), user.getName(), user.getSurname(), user.getEmail(), user.getDateOfBirth(), user.getPassword());
    }

    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE tdtd_users SET USER_USERNAME = ?, USER_NAME = ?, USER_SURNAME = ?, USER_EMAIL = ?, USER_DOB = ?, USER_PASSWORD = ? WHERE USER_ID = ?", user.getUsername(), user.getName(), user.getSurname(), user.getEmail(), user.getDateOfBirth(), user.getPassword(), user.getId());
    }

    public void deleteUser(User user) {
        jdbcTemplate.update("DELETE FROM tdtd_users WHERE USER_ID = ?", user.getId());
    }

    private User mapUser(ResultSet rs, int rowNum) throws SQLException {
        return new User(
                rs.getLong("USER_ID"),
                rs.getString("USER_USERNAME"),
                rs.getString("USER_NAME"),
                rs.getString("USER_SURNAME"),
                rs.getString("USER_EMAIL"),
                rs.getDate("USER_DOB")
        );
    }
}
