package io.github.what.todo.service;

import io.github.what.todo.entity.Todo;
import io.github.what.todo.entity.User;
import io.github.what.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodoCollectionForUser(User user) {
        return this.todoRepository.getTodoCollectionForUser(user);
    }

    public void saveTodo(Todo todo) {
        if (todo != null) {
            this.todoRepository.saveTodo(todo);
        }
    }

    public void updateTodo(Todo todo) {
        if (todo != null) {
            this.todoRepository.updateTodo(todo);
        }
    }

    public void deleteTodo(Todo todo) {
        this.todoRepository.deleteTodo(todo);
    }
}
