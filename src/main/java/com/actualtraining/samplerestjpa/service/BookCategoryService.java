package com.actualtraining.samplerestjpa.service;
import com.actualtraining.samplerestjpa.dto.BookCategoryDto;
import com.actualtraining.samplerestjpa.entity.BookCategory;

import java.util.List;

public interface BookCategoryService extends Crud<BookCategory>{
    List<BookCategory> findByName(String name);
}
