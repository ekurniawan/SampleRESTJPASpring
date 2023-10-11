package com.actualtraining.samplerestjpa.service.impl;

import com.actualtraining.samplerestjpa.dto.BookCategoryDto;
import com.actualtraining.samplerestjpa.dto.BookWithCategoryDto;
import com.actualtraining.samplerestjpa.entity.Book;
import com.actualtraining.samplerestjpa.repository.BookRepository;
import com.actualtraining.samplerestjpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Book saveOrUpdate(Book obj) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<BookWithCategoryDto> findAllWithCategory() {
        List<BookWithCategoryDto> bookWithCategoryDtos = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            bookWithCategoryDtos.add(BookWithCategoryDto.builder()
                    .id(book.getId()).title(book.getTitle())
                    .author(book.getAuthor())
                    .bookCategory(BookCategoryDto.builder().id(book.getBookCategory().getId())
                            .name(book.getBookCategory().getName()).build()).build());
        }
        return bookWithCategoryDtos;
    }


}
