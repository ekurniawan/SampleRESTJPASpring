package com.actualtraining.samplerestjpa.service;
import com.actualtraining.samplerestjpa.dto.*;

import java.util.List;

public interface CourseService {
    List<CourseResDto> getAllCourse();
    CourseResDto insertCourse(CourseReqDto courseReqDto);
    void registerStudentToCourse(CourseWithStudentDto courseWithStudentDto);
    CourseWithStudentResDto getCourseWithStudentById(Long id);
    List<CourseWithStudentResDto> getAllCourseWithStudent();
}
