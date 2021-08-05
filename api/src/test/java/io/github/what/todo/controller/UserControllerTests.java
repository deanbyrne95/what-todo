package io.github.what.todo.controller;

import io.github.what.todo.entity.User;
import io.github.what.todo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTests {

    private final String baseUrl = "/api/v1/user";

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getUserById() throws Exception {
        User mockUser = new User("Test123", "Test", "123", "Test123@test.com", new Date(12345L));

        when(userService.getUserById(any(Long.class))).thenReturn(mockUser);

        mockMvc.perform(get(baseUrl + "/{id}", 1L)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveUser() throws Exception {
        User mockUser = new User(1L,"Test123", "Test", "123", "Test123@test.com", new Date(12345L));

        doNothing().when(userService).saveUser(any(User.class));

        mockMvc.perform(post(baseUrl + "/save", mockUser)).andReturn();
    }
}
