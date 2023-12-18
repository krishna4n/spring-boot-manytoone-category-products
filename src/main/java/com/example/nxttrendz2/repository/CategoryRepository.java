
package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Category;
import java.util.ArrayList;

public interface CategoryRepository {
    ArrayList<Category> getAllCategories();

    Category addCategory(Category category);

    Category getCategoryById(int categoryId);

    Category updCategory(Category category, int categoryId);

    void deleteCategory(int categoryId);
}