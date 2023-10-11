package com.actualtraining.samplerestjpa.controller;

import com.actualtraining.samplerestjpa.dto.BookCategoryDto;
import com.actualtraining.samplerestjpa.dto.BookCategorySaveDto;
import com.actualtraining.samplerestjpa.entity.Book;
import com.actualtraining.samplerestjpa.entity.BookCategory;
import com.actualtraining.samplerestjpa.model.ErrorDesc;
import com.actualtraining.samplerestjpa.service.BookCategoryService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bookcategories")
public class BookCategoryController {
    private final Logger _logger = org.slf4j.LoggerFactory.getLogger(BookCategoryController.class);
    private final BookCategoryService bookCategoryService;

    @Autowired
    public BookCategoryController(BookCategoryService bookCategoryService) {
        this.bookCategoryService = bookCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<BookCategoryDto>> findAllBookCategories() {
        List<BookCategory> bookCategories = bookCategoryService.findAll();
        List<BookCategoryDto> bookCategoryDtos = new ArrayList<>();
        bookCategories.forEach(bookCategory -> {
            BookCategoryDto bookCategoryDto = BookCategoryDto.builder().
                    id(bookCategory.getId()).name(bookCategory.getName()).build();

            bookCategoryDtos.add(bookCategoryDto);

        });

        return ResponseEntity.ok(bookCategoryDtos);
    }

    @GetMapping("byname")
    public ResponseEntity findBookCategoryByName(@RequestParam String name) {
        List<BookCategory> bookCategories = bookCategoryService.findByName(name);
        List<BookCategoryDto> bookCategoryDtos = new ArrayList<>();
        bookCategories.forEach(bookCategory -> {
            BookCategoryDto bookCategoryDto = BookCategoryDto.builder().
                    id(bookCategory.getId()).name(bookCategory.getName()).build();
            bookCategoryDtos.add(bookCategoryDto);
        });
        return ResponseEntity.ok(bookCategoryDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity findBookCategoryById(@PathVariable int id) {
        BookCategory bookCategory = bookCategoryService.findById(id);
        if(bookCategory.getId() != 0) {
            BookCategoryDto bookCategoryDto = BookCategoryDto.builder().
                    id(bookCategory.getId()).name(bookCategory.getName()).build();
            return ResponseEntity.ok(bookCategoryDto);
        }
        else {
           return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity saveBookCategory(@RequestBody BookCategorySaveDto bookCategorySaveDto) {
        BookCategory bookCategory = new BookCategory();

        bookCategory = bookCategoryService.saveOrUpdate(new BookCategory(bookCategorySaveDto.getName(),
        new Book("Book1", "Author1"),new Book("Book2", "Author2")));

        bookCategory = bookCategoryService.saveOrUpdate(bookCategory);

        BookCategoryDto bookCategoryDto = BookCategoryDto.builder().
                id(bookCategory.getId()).name(bookCategory.getName()).build();
        return ResponseEntity.created(null).body(bookCategoryDto);
    }

    @PutMapping("{id}")
    public ResponseEntity updateBookCategory(@PathVariable int id,
                                             @RequestBody BookCategorySaveDto bookCategorySaveDto) {
        BookCategory bookCategory = bookCategoryService.findById(id);
        if(bookCategory.getId() != 0) {
            try {
                bookCategory.setName(bookCategorySaveDto.getName());
                bookCategoryService.saveOrUpdate(bookCategory);
            }
            catch (Exception ex) {
                return ResponseEntity.badRequest().body(new ErrorDesc(119,ex.getMessage()));
            }

            BookCategoryDto bookCategoryDto = BookCategoryDto.builder().
                    id(bookCategory.getId()).name(bookCategory.getName()).build();
            return ResponseEntity.ok(bookCategoryDto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteBookCategory(@PathVariable int id) {
        BookCategory bookCategory = bookCategoryService.findById(id);
        if(bookCategory.getId() != 0) {
            bookCategoryService.delete(id);
            return ResponseEntity.ok().body("BookCategory with id " + id + " deleted");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
