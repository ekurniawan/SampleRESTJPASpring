package com.actualtraining.samplerestjpa.service.impl;

import com.actualtraining.samplerestjpa.entity.BookCategory;
import com.actualtraining.samplerestjpa.repository.BookCategoryRepository;
import com.actualtraining.samplerestjpa.repository.BookRepository;
import com.actualtraining.samplerestjpa.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService{


    private final BookCategoryRepository bookCategoryRepository;

    @Autowired
    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository) {
        this.bookCategoryRepository = bookCategoryRepository;
    }

    @Override
    public List<BookCategory> findAll() {
        return bookCategoryRepository.findAllCategoriesNative();
    }

    @Override
    public BookCategory findById(int id) {
        return bookCategoryRepository.findById(id).orElse(new BookCategory());
    }

    @Override
    public BookCategory saveOrUpdate(BookCategory obj) {
        return bookCategoryRepository.save(obj);
    }

    @Override
    public void delete(int id) {
        BookCategory bookCategory = findById(id);
        if(bookCategory.getId() != 0)
            bookCategoryRepository.delete(bookCategory);
        else
            throw new RuntimeException("BookCategory with id " + id + " not found");
    }

    @Override
    public List<BookCategory> findByName(String name) {
        return bookCategoryRepository.findByNameContaining(name);
    }


}
