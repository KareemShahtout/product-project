package com.company.products.dao;

import com.company.products.entity.Product;

import java.util.List;

public interface ProductDao {

    Product save(Product product);

    boolean deleteById(int id);

    Product update(Product product);

    Product findById(int id);

    List<Product> findAll();

}
