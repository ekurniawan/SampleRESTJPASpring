package com.actualtraining.samplerestjpa.service.impl;

import com.actualtraining.samplerestjpa.dto.CourseReqDto;
import com.actualtraining.samplerestjpa.dto.CourseResDto;
import com.actualtraining.samplerestjpa.dto.CourseWithStudentDto;
import com.actualtraining.samplerestjpa.dto.CourseWithStudentResDto;
import com.actualtraining.samplerestjpa.entity.Course;
import com.actualtraining.samplerestjpa.repository.CourseRepository;
import com.actualtraining.samplerestjpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseResDto> getAllCourse() {
        List<CourseResDto> courseResDtoList = new ArrayList<>();
        List<Course> courseList = courseRepository.findAll();
        for (Course course : courseList) {
            courseResDtoList.add(CourseResDto.builder()
                    .id(course.getId())
                    .title(course.getTitle())
                    .modules(course.getModules())
                    .fee(course.getFee())
                    .build());
        }
        return courseResDtoList;
    }

    @Override
    public CourseResDto insertCourse(CourseReqDto courseReqDto) {
        Course course = Course.builder()
                .title(courseReqDto.getTitle())
                .modules(courseReqDto.getModules())
                .fee(courseReqDto.getFee())
                .build();
        course = courseRepository.save(course);
        CourseResDto courseResDto = CourseResDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .modules(course.getModules())
                .fee(course.getFee())
                .build();

        return courseResDto;
    }

    @Override
    public void registerStudentToCourse(CourseWithStudentDto courseWithStudentDto) {

    }

    @Override
    public CourseWithStudentResDto getCourseWithStudentById(Long id) {
        return null;
    }

    @Override
    public List<CourseWithStudentResDto> getAllCourseWithStudent() {
        return null;
    }
}
