package com.actualtraining.samplerestjpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Book {

    public Book(String title,String author){
        this.title = title;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    //FK
    @ManyToOne
    @JoinColumn(name = "book_category_id", nullable = false)
    private BookCategory bookCategory;
}
