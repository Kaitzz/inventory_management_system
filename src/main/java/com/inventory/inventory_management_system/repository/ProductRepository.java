package com.inventory.inventory_management_system.repository;
import com.inventory.inventory_management_system.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Spring Data JPA automatically provides CRUD methods (save, findById, delete, etc.)
    // You can add custom query methods here later!
}