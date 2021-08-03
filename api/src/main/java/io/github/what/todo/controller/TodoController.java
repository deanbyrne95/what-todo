package io.github.what.todo.controller;

import io.github.what.todo.entity.Todo;
import io.github.what.todo.entity.User;
import io.github.what.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.github.what.todo.constant.ApiVersion.CURRENT_VERSION;

@RestController
@RequestMapping(CURRENT_VERSION + "/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodoCollectionForUser(@RequestBody User user) {
        return ResponseEntity.ok(this.todoService.getTodoCollectionForUser(user));
    }

    @PostMapping("/save")
    public void saveTodo(@RequestBody Todo todo) {
        this.todoService.saveTodo(todo);
    }

    @PutMapping("/update")
    public void updateTodo(@RequestBody Todo todo) {
        this.todoService.updateTodo(todo);
    }

    @DeleteMapping("/delete")
    public void deleteTodo(@RequestBody Todo todo) {
        this.todoService.deleteTodo(todo);
    }

}
