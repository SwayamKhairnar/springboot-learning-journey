package com.swayam.ecommerce.controller;

import com.swayam.ecommerce.model.Product;
import com.swayam.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "E-Commerce REST API is Running!";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer prodId) {
        Product prod = service.getProduct(prodId);
        return (prod != null)
                ? ResponseEntity.ok(prod)
                : ResponseEntity.notFound().build();
    }

    @PostMapping(
            value = "/product",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
        try {
            Product savedProduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding product: " + e.getMessage());
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getProductImage(@PathVariable Integer id) {
        Product product = service.getProduct(id);

        if (product == null || product.getImageData() == null) {
            return ResponseEntity.notFound().build();
        }

        String imageType = product.getImageType();
        MediaType mediaType;
        try {
            mediaType = (imageType != null && !imageType.isBlank())
                    ? MediaType.valueOf(imageType)
                    : MediaType.APPLICATION_OCTET_STREAM;
        } catch (Exception e) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        }

        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(product.getImageData());
    }

    @PutMapping(
            value = "/product/{id}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> updateProduct(
            @PathVariable Integer id,
            @RequestPart("product") Product updatedProduct,
            @RequestPart(value = "imageFile", required = false) MultipartFile imageFile) {
        try {
            Product product = service.updateProduct(id, updatedProduct, imageFile);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating product: " + e.getMessage());
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        boolean deleted = service.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.ok("Product Deleted Successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exist!");
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "keyword", required = false) String keyword) {
        String query = name != null ? name : (keyword != null ? keyword : "");
        List<Product> products = service.searchProducts(query);
        return ResponseEntity.ok(products);
    }
}
