package com.actualtraining.samplerestjpa.dto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseWithStudentResDto {
    private Long id;
    private String title;
    private int modules;
    private double fee;
    List<StudentResDto> studentResDtoList;
}
