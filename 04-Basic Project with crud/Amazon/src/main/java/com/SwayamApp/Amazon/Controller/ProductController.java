package com.SwayamApp.Amazon.Controller;

import com.SwayamApp.Amazon.Model.Product;
import com.SwayamApp.Amazon.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class ProductController {
    private final ProductService productService;
    ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProduct();
    }
    @GetMapping("/products/{ProdId}")
    public Product getProductById(@PathVariable int ProdId){
        return productService.getProductById(ProdId);
    }
    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        productService.addProduct(prod);
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        productService.updateProduct(prod);
    }
    @DeleteMapping("/products")
    public void deleteProduct(@RequestBody Product prod){
        productService.deleteProduct(prod);
    }
}
