package com.actualtraining.samplerestjpa.repository;

import com.actualtraining.samplerestjpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
