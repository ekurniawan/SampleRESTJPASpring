package com.actualtraining.samplerestjpa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResDto {
    private Long id;
    private String title;
    private int modules;
    private double fee;
}
