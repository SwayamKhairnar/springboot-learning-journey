package com.swayam.layered;

import com.swayam.layered.controller.UserController;
import com.swayam.layered.repository.UserRepository;
import com.swayam.layered.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LayeredArchitectureTest {

    @Test
    void testLayeredArchitectureFlow() {
        UserRepository repository = new UserRepository();
        UserService service = new UserService(repository);
        UserController controller = new UserController(service);

        assertEquals(2, service.getAllUsers().size());

        controller.createUser(3, "Charlie", "charlie@example.com");
        assertEquals(3, service.getAllUsers().size());
    }
}
