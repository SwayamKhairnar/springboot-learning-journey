package com.swayam.layered.service;

import com.swayam.layered.model.User;
import com.swayam.layered.repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserRepository repository;

    // Constructor injection
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        System.out.println("[Service] Applying business logic to fetch all users");
        return repository.findAll();
    }

    public Optional<User> getUserById(int id) {
        System.out.println("[Service] Fetching user by ID: " + id);
        return repository.findById(id);
    }

    public void registerUser(User user) {
        System.out.println("[Service] Validating and registering user: " + user.getName());
        repository.save(user);
    }
}
