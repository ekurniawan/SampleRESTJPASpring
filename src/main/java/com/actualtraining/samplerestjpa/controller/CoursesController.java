package com.actualtraining.samplerestjpa.controller;

import com.actualtraining.samplerestjpa.dto.CourseReqDto;
import com.actualtraining.samplerestjpa.dto.CourseResDto;
import com.actualtraining.samplerestjpa.dto.CourseWithStudentDto;
import com.actualtraining.samplerestjpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    private final CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseResDto>> getAllCourse() {
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    @PostMapping
    public ResponseEntity<CourseResDto> insertCourse(@RequestBody CourseReqDto courseReqDto) {
        return ResponseEntity.created(null).body(courseService.insertCourse(courseReqDto));
    }

    @PostMapping("/addstudent")
    public ResponseEntity addStudentToCourse(@RequestBody CourseWithStudentDto courseWithStudentDto) {
        try {
            courseService.registerStudentToCourse(courseWithStudentDto);
            return ResponseEntity.created(null).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        //return ResponseEntity.ok().body(courseWithStudentDto.getCourseId()+" "+courseWithStudentDto.getStudentId());
    }

    @GetMapping("/withstudent/{id}")
    public ResponseEntity getCourseWithStudentById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseService.getCourseWithStudentById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
