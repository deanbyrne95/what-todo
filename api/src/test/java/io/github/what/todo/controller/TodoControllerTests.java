package io.github.what.todo.controller;

import io.github.what.todo.entity.Todo;
import io.github.what.todo.entity.User;
import io.github.what.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TodoController.class)
public class TodoControllerTests {

    private final String baseUrl = "/api/v1/todo";

    @MockBean
    private TodoService todoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTodoCollectionForUser() throws Exception {
        Todo mockTodo = new Todo("Sample Task", LocalDateTime.now(), false, false);
        List<Todo> todoList = new ArrayList<>();
        todoList.add(mockTodo);
        User mockUser = new User(1L,"Test123", "Test", "123", "Test123@test.com", new Date(12345L));

        when(todoService.getTodoCollectionForUser(any(User.class))).thenReturn(todoList);

        mockMvc.perform(get(baseUrl, mockUser)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void saveTodo() throws Exception {
        User mockUser = new User(1L,"Test123", "Test", "123", "Test123@test.com", new Date(12345L));
        Todo mockTodo = new Todo(1L, mockUser, "Sample Task", LocalDateTime.now(), false, false);

        doNothing().when(todoService).saveTodo(any(Todo.class));

        mockMvc.perform(post(baseUrl + "/save", mockTodo)).andReturn();
    }
}
