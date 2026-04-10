package com.company.products.service;

import com.company.products.dao.ProductDao;
import com.company.products.entity.Product;
import com.company.products.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean deleteById(int id) {
        return productDao.deleteById(id);
    }

    @Override
    public Product update(Product product) {

        Product existingProduct = productDao.findById(product.getId());

        if (existingProduct == null) {
            throw new RuntimeException("Product with id " + product.getId() + " not found");
        }

        existingProduct.setName(product.getName());

        if (existingProduct.getProductDetails() == null) {
            existingProduct.setProductDetails(new ProductDetails());
        }

        existingProduct.getProductDetails().setName(product.getProductDetails().getName());
        existingProduct.getProductDetails().setPrice(product.getProductDetails().getPrice());
        existingProduct.getProductDetails().setAvailable(product.getProductDetails().getAvailable());
        existingProduct.getProductDetails().setManufacturer(product.getProductDetails().getManufacturer());
        existingProduct.getProductDetails().setExpirationDate(product.getProductDetails().getExpirationDate());

        return existingProduct;
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
