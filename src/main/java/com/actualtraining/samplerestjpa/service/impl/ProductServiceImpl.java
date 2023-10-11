package com.actualtraining.samplerestjpa.service.impl;
import com.actualtraining.samplerestjpa.entity.Product;
import com.actualtraining.samplerestjpa.repository.ProductRepository;
import com.actualtraining.samplerestjpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll(Sort.by("name"));
    }

    @Override
    public Product findById(int id) {
        Product product = productRepository.findById(id).orElse(new Product());
        if(product.getId() != 0)
            return product;
        else
            throw new RuntimeException("Product with id " + id + " not found");
    }

    @Override
    public Product saveOrUpdate(Product product) {
        try{
            return productRepository.save(product);
        }
        catch (JpaSystemException jpaEX) {
            throw new RuntimeException(jpaEX.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        if(product.getId() != 0)
            productRepository.delete(product);
        else
            throw new RuntimeException("Product with id " + id + " not found");
    }
}
