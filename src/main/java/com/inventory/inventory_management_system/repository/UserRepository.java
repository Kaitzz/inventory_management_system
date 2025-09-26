package com.inventory.inventory_management_system.repository;

import com.inventory.inventory_management_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Security needs this method to look up users by their username
    Optional<User> findByUsername(String username);
}