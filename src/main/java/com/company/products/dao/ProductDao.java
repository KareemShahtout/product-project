package com.company.products.dao;

import com.company.products.entity.Product;

import java.util.List;

public interface ProductDao {

    void save(Product product);

    void deleteById(int id);

    void update(Product product);

    Product findById(int id);

    List<Product> findAll();

}
