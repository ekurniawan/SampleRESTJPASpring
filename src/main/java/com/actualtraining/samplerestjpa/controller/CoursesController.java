package com.actualtraining.samplerestjpa.controller;

import com.actualtraining.samplerestjpa.dto.CourseReqDto;
import com.actualtraining.samplerestjpa.dto.CourseResDto;
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
}
