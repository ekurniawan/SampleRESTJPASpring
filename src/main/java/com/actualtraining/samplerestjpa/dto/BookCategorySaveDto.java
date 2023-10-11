package com.actualtraining.samplerestjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookCategorySaveDto {
    private String name;
    List<BookSaveDto> books;
}
