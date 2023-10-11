package com.actualtraining.samplerestjpa.repository;
import com.actualtraining.samplerestjpa.dto.BookWithCategoryDto;
import com.actualtraining.samplerestjpa.entity.Book;
import com.actualtraining.samplerestjpa.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>{
    @Query(value = "select book.id,book.title,book.author,book_category.id as book_category_id,book_category.name from book INNER JOIN book_category on book.book_category_id = book_category.id", nativeQuery = true)
    List<Book> findAllBookNative();
}
