package com.actualtraining.samplerestjpa.service.impl;

import com.actualtraining.samplerestjpa.dto.*;
import com.actualtraining.samplerestjpa.entity.Course;
import com.actualtraining.samplerestjpa.entity.Student;
import com.actualtraining.samplerestjpa.repository.CourseRepository;
import com.actualtraining.samplerestjpa.repository.StudentRepository;
import com.actualtraining.samplerestjpa.service.CourseService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(CourseServiceImpl.class);
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository,
                             StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
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
        Course course = courseRepository.findById(courseWithStudentDto.getCourseId()).get();
        Student student = studentRepository.findById(courseWithStudentDto.getStudentId()).get();

        logger.info(course.getTitle());
        logger.info(student.getName());

        try{
            student.getCourses().add(course);
            studentRepository.save(student);

            //course.getStudents().add(student);
            //courseRepository.save(course);
        }catch (Exception e) {
            logger.error(e.getMessage());
        }

    }

    @Override
    public CourseWithStudentResDto getCourseWithStudentById(Long id) {
        Course course = courseRepository.findById(id).get();
        List<Student> studentList = course.getStudents();
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        for(Student student : studentList){
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .age(student.getAge())
                    .build());
        }
        return CourseWithStudentResDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .modules(course.getModules())
                .fee(course.getFee())
                .studentResDtoList(studentResDtoList)
                .build();
    }

    @Override
    public List<CourseWithStudentResDto> getAllCourseWithStudent() {
        return null;
    }
}
