package com.Ecom.Amazon.controller;

import com.Ecom.Amazon.model.Product;
import com.Ecom.Amazon.service.productService;
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
public class productController {

    private final productService service;

    public productController(productService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return "Hello Amazon";
    }

    //viewing all product
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }


    //viewing single product
    @GetMapping("/product/{prodId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer prodId) {
        Product prod = service.getProduct(prodId);
        return (prod != null)
                ? ResponseEntity.ok(prod)
                : ResponseEntity.notFound().build();
    }

    //adding product
    @PostMapping(
            value = "/product",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) {

        try {
            Product savedProduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); //for debug
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //view image


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
        } catch (RuntimeException | IOException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        Product product1=service.getProduct(id);

        if (product1!=null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Product Deleted! ",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Product Doesn't Exists! ",HttpStatus.BAD_REQUEST);
        }
    }
}
