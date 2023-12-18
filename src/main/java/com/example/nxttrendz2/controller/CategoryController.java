package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.service.CategoryJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nxttrendz2.model.*;
import java.util.ArrayList;

@RestController
public class CategoryController {

    @Autowired
    private CategoryJpaService categoryService;

    @GetMapping("/categories")
    public ArrayList<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") int categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@RequestBody Category category, @PathVariable int categoryId) {
        return categoryService.updCategory(category, categoryId);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}