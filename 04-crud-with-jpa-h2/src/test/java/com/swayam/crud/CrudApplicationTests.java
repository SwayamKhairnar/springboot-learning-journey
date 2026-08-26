package com.swayam.crud;

import com.swayam.crud.model.Product;
import com.swayam.crud.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CrudApplicationTests {

    @Autowired
    private ProductRepository repository;

    @Test
    void testProductCrudOperations() {
        Product product = new Product("Laptop", 1200.00);
        Product saved = repository.save(product);

        assertNotNull(saved.getId());
        assertEquals("Laptop", saved.getName());

        Product fetched = repository.findById(saved.getId()).orElse(null);
        assertNotNull(fetched);
        assertEquals(1200.00, fetched.getPrice());

        repository.delete(saved);
        assertEquals(0, repository.count());
    }

}
