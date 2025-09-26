package com.inventory.inventory_management_system.controller;

import com.inventory.inventory_management_system.model.Product;
import com.inventory.inventory_management_system.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // This class is a web controller for handling web page requests
public class ProductWebController {

    private final ProductService productService;

    public ProductWebController(ProductService productService) {
        this.productService = productService;
    }

    // This method handles GET requests to the "/products" URL
    @GetMapping("/products")
    public String listProducts(Model model) {
        // 1. Get all products from the service layer
        model.addAttribute("products", productService.getAllProducts());

        // 2. Return the name of the HTML file (without the .html extension)
        // Spring Boot will look for "products-list.html" in the "templates" folder
        return "products-list";
    }

    // Method to show the "add product" form
    @GetMapping("/products/new")
    public String showAddProductForm(Model model) {
        // We pass an empty Product object to bind the form data to
        model.addAttribute("product", new Product());
        return "add-product"; // Returns add-product.html
    }

    // Method to process the form submission
    @PostMapping("/products")
    public String addProduct(Product product) {
        // The "product" object is automatically populated with form data
        productService.createProduct(product);
        return "redirect:/products"; // Redirect back to the product list page
    }
}