package com.turner.Ecommerce.services;

import com.turner.Ecommerce.entities.Product;
import com.turner.Ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) {
        return productRepository.getOne(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public boolean productExistsById(int id) {
        return productRepository.existsById(id);
    }

}
