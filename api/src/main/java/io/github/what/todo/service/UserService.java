package io.github.what.todo.service;

import io.github.what.todo.entity.User;
import io.github.what.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return this.userRepository.getUserById(id);
    }

    public void saveUser(User user) {
        if (user != null) {
            this.userRepository.saveUser(user);
        }
    }

    public void updateUser(User user) {
        if (user != null) {
            this.userRepository.updateUser(user);
        }
    }

    public void deleteUser(User user) {
        this.userRepository.deleteUser(user);
    }
}
