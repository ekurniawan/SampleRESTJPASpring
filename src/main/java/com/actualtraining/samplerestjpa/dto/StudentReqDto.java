package com.actualtraining.samplerestjpa.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentReqDto {
    private String name;
    private int age;
}
