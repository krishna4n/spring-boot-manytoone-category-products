
package com.example.nxttrendz2.service;

import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryJpaService implements CategoryRepository {

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public ArrayList<Category> getAllCategories() {
        try {
            List<Category> category = categoryJpaRepository.findAll();
            return (ArrayList<Category>) category;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category addCategory(Category category) {
        try {
            categoryJpaRepository.save(category);
            return category;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category getCategoryById(int categoryId) {
        try {
            Category category = categoryJpaRepository.findById(categoryId).get();
            return category;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Category updCategory(Category category, int categoryId) {
        try {
            Category c = categoryJpaRepository.findById(categoryId).get();
            if (category.getName() != "") {
                c.setName(category.getName());
            }
            if (category.getDescription() != "") {
                c.setDescription(category.getDescription());
            }
            categoryJpaRepository.save(c);

            return c;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        try {
            categoryJpaRepository.deleteById(categoryId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

}