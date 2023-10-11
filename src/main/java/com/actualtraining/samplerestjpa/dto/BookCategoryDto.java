package com.actualtraining.samplerestjpa.dto;

import com.actualtraining.samplerestjpa.entity.BookCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BookCategoryDto {

    private int id;
    private String name;
}
