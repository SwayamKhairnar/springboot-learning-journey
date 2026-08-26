package com.swayam.layered;

import com.swayam.layered.controller.UserController;
import com.swayam.layered.repository.UserRepository;
import com.swayam.layered.service.UserService;

public class Application {

    public static void main(String[] args) {
        System.out.println("=== Demonstrating Controller-Service-Repository Flow ===");

        // 1. Instantiate Repository Layer (Data Access)
        UserRepository repository = new UserRepository();

        // 2. Inject Repository into Service Layer (Business Logic)
        UserService service = new UserService(repository);

        // 3. Inject Service into Controller Layer (Presentation / Request Handling)
        UserController controller = new UserController(service);

        // 4. Execute requests through the controller
        controller.displayUsers();
        controller.createUser(3, "Charlie", "charlie@example.com");
        controller.displayUsers();
    }
}
