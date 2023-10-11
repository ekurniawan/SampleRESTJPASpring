package com.actualtraining.samplerestjpa.controller;

import com.actualtraining.samplerestjpa.dto.StudentReqDto;
import com.actualtraining.samplerestjpa.dto.StudentResDto;
import com.actualtraining.samplerestjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
    private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentResDto>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PostMapping
    public ResponseEntity<StudentResDto> insertStudent(@RequestBody StudentReqDto studentReqDto) {
        return ResponseEntity.created(null).body(studentService.insertStudent(studentReqDto));
    }
}
