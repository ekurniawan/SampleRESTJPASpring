package com.actualtraining.samplerestjpa.repository;
import com.actualtraining.samplerestjpa.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
     List<BookCategory> findByNameContaining(String name);
     @Query(value = "SELECT * FROM book_category order by name desc", nativeQuery = true)
     List<BookCategory> findAllCategoriesNative();
}