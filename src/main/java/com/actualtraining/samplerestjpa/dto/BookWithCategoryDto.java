package com.actualtraining.samplerestjpa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@Builder
public class BookWithCategoryDto {
    private int id;
    private String title;
    private String author;
    private BookCategoryDto bookCategory;
}
