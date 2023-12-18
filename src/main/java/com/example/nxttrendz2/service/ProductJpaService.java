
package com.example.nxttrendz2.service;

import java.util.ArrayList;
import java.util.List;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.model.Product;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.ProductJpaRepository;
import com.example.nxttrendz2.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductJpaService implements ProductRepository {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public ArrayList<Product> getAllProducts() {
        try {
            List<Product> product = productJpaRepository.findAll();
            return (ArrayList<Product>) product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product addProduct(Product product) {
        try {
            Category category = product.getCategory();
            int categoryId = category.getId();
            Category c = categoryJpaRepository.findById(categoryId).get();
            product.setCategory(c);
            productJpaRepository.save(product);
            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product getProductById(int productId) {
        try {
            Product product = productJpaRepository.findById(productId).get();

            return product;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Product updateProduct(Product product, int productId) {
        try {
            Product p = productJpaRepository.findById(productId).get();
            if (product.getName() != "") {
                p.setName(product.getName());
            }
            if (product.getDescription() != "") {
                p.setDescription(product.getDescription());
            }
            if (product.getPrice() != 00.00) {
                p.setPrice(product.getPrice());
            }
            Category category = product.getCategory();
            int categoryId = category.getId();
            Category c = categoryJpaRepository.findById(categoryId).get();
            p.setCategory(c);
            productJpaRepository.save(p);
            return p;
        }

        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    // TODO Auto-generated method stub

    @Override
    public void deleteProduct(int productId) {
        try {
            productJpaRepository.deleteById(productId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);

    }

    @Override
    public Category getProductCategory(int productId) {
        try {
            Product p = productJpaRepository.findById(productId).get();
            Category c = p.getCategory();
            Category category = categoryJpaRepository.findById(c.getId()).get();
            return category;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}