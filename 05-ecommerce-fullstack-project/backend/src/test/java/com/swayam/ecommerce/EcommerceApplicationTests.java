package com.swayam.ecommerce;

import com.swayam.ecommerce.model.Product;
import com.swayam.ecommerce.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EcommerceApplicationTests {

    @Autowired
    private ProductRepository repository;

    @Test
    void contextLoads() {
        assertNotNull(repository);
    }

    @Test
    void testProductCreationAndSearch() {
        Product product = new Product();
        product.setName("Sony WH-1000XM5");
        product.setDescription("Industry leading wireless noise cancelling headphones");
        product.setBrand("Sony");
        product.setCategory("Headphones");
        product.setPrice(new BigDecimal("399.99"));
        product.setReleaseDate(new Date());
        product.setProductAvailable(true);
        product.setStockQuantity(25);

        Product saved = repository.save(product);
        assertNotNull(saved.getId());

        // Test search query
        List<List<Product>> testSearches = List.of(
                repository.searchProducts("Sony"),
                repository.searchProducts("noise"),
                repository.searchProducts("Headphones")
        );

        for (List<Product> results : testSearches) {
            assertFalse(results.isEmpty());
            assertEquals("Sony WH-1000XM5", results.get(0).getName());
        }

        repository.delete(saved);
        assertEquals(0, repository.count());
    }

}
