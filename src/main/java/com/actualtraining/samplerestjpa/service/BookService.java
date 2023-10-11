package com.actualtraining.samplerestjpa.service;
import com.actualtraining.samplerestjpa.dto.BookWithCategoryDto;
import com.actualtraining.samplerestjpa.entity.Book;

import java.util.List;

public interface BookService extends Crud<Book>{
    public List<BookWithCategoryDto> findAllWithCategory();
}
