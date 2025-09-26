package com.inventory.inventory_management_system.service;

import com.inventory.inventory_management_system.model.Product;
import com.inventory.inventory_management_system.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service component
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired // Injects the ProductRepository dependency
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        // Find the existing product or throw an exception
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        // Update the fields
        existingProduct.setName(productDetails.getName());
        existingProduct.setQuantity(productDetails.getQuantity());
        existingProduct.setPrice(productDetails.getPrice());

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        // Check if the product exists before deleting
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}