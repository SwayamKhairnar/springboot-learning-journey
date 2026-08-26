package com.swayam.ecommerce.service;

import com.swayam.ecommerce.model.Product;
import com.swayam.ecommerce.repo.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository prodRepo;

    public ProductService(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public Product getProduct(Integer prodId) {
        return prodRepo.findById(prodId).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        if (imageFile != null && !imageFile.isEmpty()) {
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
            product.setImageData(imageFile.getBytes());
        }
        return prodRepo.save(product);
    }

    public Product updateProduct(Integer id, Product product, MultipartFile imageFile) throws IOException {
        Product existingProduct = prodRepo.findById(id).orElse(null);

        product.setId(id);

        if (imageFile != null && !imageFile.isEmpty()) {
            product.setImageData(imageFile.getBytes());
            product.setImageName(imageFile.getOriginalFilename());
            product.setImageType(imageFile.getContentType());
        } else if (existingProduct != null) {
            // Preserve existing image if no new image was uploaded
            product.setImageData(existingProduct.getImageData());
            product.setImageName(existingProduct.getImageName());
            product.setImageType(existingProduct.getImageType());
        }

        return prodRepo.save(product);
    }

    public boolean deleteProduct(Integer id) {
        if (prodRepo.existsById(id)) {
            prodRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Product> searchProducts(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return prodRepo.findAll();
        }
        return prodRepo.searchProducts(keyword.trim());
    }
}
