package io.github.what.todo.controller;

import io.github.what.todo.entity.User;
import io.github.what.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static io.github.what.todo.constant.ApiVersion.CURRENT_VERSION;

@RestController
@RequestMapping(CURRENT_VERSION + "/user")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        this.userService.saveUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user) {
        this.userService.deleteUser(user);
    }

}
