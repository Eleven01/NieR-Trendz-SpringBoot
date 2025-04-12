package com.example.YoRHa.controller;

import com.example.YoRHa.model.Product;
import com.example.YoRHa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")

public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updated) {
        Product product = repository.findById(id).orElseThrow();
        product.setName(updated.getName());
        product.setPrice(updated.getPrice());
        product.setDescription(updated.getDescription());
        return repository.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

}
