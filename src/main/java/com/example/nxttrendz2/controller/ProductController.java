
package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.service.ProductJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    private ProductJpaService productService;

    @GetMapping("/categories/products")
    public ArrayList<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/categories/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/categories/products/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @PutMapping("/categories/products/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int productId) {
        return productService.updateProduct(product, productId);
    }

    @DeleteMapping("/categories/products/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/products/{productId}/category")
    public Category getProductCategory(@PathVariable int productId) {
        return productService.getProductCategory(productId);
    }

}