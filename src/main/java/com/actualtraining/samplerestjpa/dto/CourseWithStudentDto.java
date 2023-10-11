package com.actualtraining.samplerestjpa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseWithStudentDto {
    private Long studentId;
    private Long courseId;
}
