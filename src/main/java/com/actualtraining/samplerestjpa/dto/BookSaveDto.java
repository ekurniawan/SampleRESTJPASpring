package com.actualtraining.samplerestjpa.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookSaveDto {
    private String title;
    private String author;
}
