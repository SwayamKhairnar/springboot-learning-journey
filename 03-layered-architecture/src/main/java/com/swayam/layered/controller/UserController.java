package com.swayam.layered.controller;

import com.swayam.layered.model.User;
import com.swayam.layered.service.UserService;
import java.util.List;

public class UserController {

    private final UserService userService;

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void displayUsers() {
        System.out.println("[Controller] Handling request: GET /users");
        List<User> users = userService.getAllUsers();
        users.forEach(System.out::println);
    }

    public void createUser(int id, String name, String email) {
        System.out.println("[Controller] Handling request: POST /users");
        userService.registerUser(new User(id, name, email));
    }
}
