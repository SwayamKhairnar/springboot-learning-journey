package com.SwayamApp.Amazon.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.SwayamApp.Amazon.Controller.ProductController;
import com.SwayamApp.Amazon.Model.Product;
import com.SwayamApp.Amazon.Repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProductService {
    @Autowired
    ProductRepo repo;
//    ProductService(ProductRepo repo) {
//        this.repo = repo;
//    }
//    List<Product> products= new ArrayList<>(
//            Arrays.asList(
//                    new Product(101,"Iphone", 50000),
//                    new Product(102,"Nokia", 100000),
//                    new Product(103,"Samsung",100000)
//            )
//    );

    public List<Product> getProduct(){
        return (List<Product>) repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
         repo.save(prod);
    }

    public void deleteProduct(Product prod) {
        repo.delete(prod);
    }
}
