package com.inventory.inventory_management_system.service;

import com.inventory.inventory_management_system.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product createProduct(Product product);

    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product productDetails);

    void deleteProduct(Long id);
}