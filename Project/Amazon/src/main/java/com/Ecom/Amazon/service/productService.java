package com.Ecom.Amazon.service;

import com.Ecom.Amazon.model.Product;
import com.Ecom.Amazon.repo.productRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class productService {

    private final productRepo prodRepo;

    public productService(productRepo prodRepo) {
        this.prodRepo = prodRepo;
    }

    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public Product getProduct(Integer prodId) {
        return prodRepo.findById(prodId).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());

        return prodRepo.save(product);
    }

    public Product updateProduct(Integer id, Product product, MultipartFile imageFile) throws IOException {

        product.setImageData(imageFile.getBytes());;
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());

        return prodRepo.save(product);
    }

    public void deleteProduct(Integer id) {
        prodRepo.deleteById(id);
    }
}
