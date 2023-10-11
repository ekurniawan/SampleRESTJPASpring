package com.actualtraining.samplerestjpa.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CourseReqDto {
    private String title;
    private int modules;
    private double fee;
}
