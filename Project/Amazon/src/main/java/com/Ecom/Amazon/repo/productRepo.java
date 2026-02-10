package com.Ecom.Amazon.repo;

import com.Ecom.Amazon.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<Product, Integer> {
}
