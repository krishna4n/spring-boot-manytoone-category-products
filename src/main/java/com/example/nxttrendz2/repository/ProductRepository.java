package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import java.util.ArrayList;

public interface ProductRepository {
    ArrayList<Product> getAllProducts();

    Product addProduct(Product product);

    Product getProductById(int productId);

    Product updateProduct(Product product, int productId);

    void deleteProduct(int productId);

    Category getProductCategory(int productId);

}