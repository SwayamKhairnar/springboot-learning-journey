package com.swayam.layered.repository;

import com.swayam.layered.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private final List<User> database = new ArrayList<>();

    public UserRepository() {
        // Seed initial data
        database.add(new User(1, "Alice", "alice@example.com"));
        database.add(new User(2, "Bob", "bob@example.com"));
    }

    public List<User> findAll() {
        return new ArrayList<>(database);
    }

    public Optional<User> findById(int id) {
        return database.stream().filter(u -> u.getId() == id).findFirst();
    }

    public void save(User user) {
        database.add(user);
    }
}
