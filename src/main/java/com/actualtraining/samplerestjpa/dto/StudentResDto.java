package com.actualtraining.samplerestjpa.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResDto {
    private Long id;
    private String name;
    private int age;
}
