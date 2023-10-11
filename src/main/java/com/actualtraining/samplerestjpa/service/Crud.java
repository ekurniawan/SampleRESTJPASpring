package com.actualtraining.samplerestjpa.service;

import com.actualtraining.samplerestjpa.entity.Product;

import java.util.List;

public interface Crud<T> {
    List<T> findAll();
    T findById(int id);
    T saveOrUpdate(T obj);
    void delete(int id);
}
