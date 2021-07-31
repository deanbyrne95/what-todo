package io.github.what.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.what.todo.constant.ApiVersion.CURRENT_VERSION;

@RestController
@RequestMapping(CURRENT_VERSION + "/user")
public class UserController {

    public UserController() {}

    @GetMapping
    public ResponseEntity getUser() {
        return ResponseEntity.ok("Hello World!");
    }

}
