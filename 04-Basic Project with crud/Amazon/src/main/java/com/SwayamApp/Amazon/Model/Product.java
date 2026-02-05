package com.SwayamApp.Amazon.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Product {
    @Id
    int ProductId;
    String ProductName;
    int ProductPrice;
//    public Product(int productId, String productName, int productPrice) {
//        this.ProductId = productId;
//        this.ProductName = productName;
//        this.ProductPrice = productPrice;
//    }



}
