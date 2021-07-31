package io.github.what.todo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTests {

    @Mock
    private UserController userController;

    @BeforeEach
    public void init() {
        userController = new UserController();
        MockitoAnnotations.openMocks(userController);
    }

    @Test
    void getUser() {
        ResponseEntity re = userController.getUser();
        assertEquals("Hello World!", re.getBody());
    }
}
