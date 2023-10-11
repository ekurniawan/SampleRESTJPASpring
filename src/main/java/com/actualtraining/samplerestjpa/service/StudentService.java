package com.actualtraining.samplerestjpa.service;

import com.actualtraining.samplerestjpa.dto.StudentReqDto;
import com.actualtraining.samplerestjpa.dto.StudentResDto;

import java.util.List;

public interface StudentService {
    List<StudentResDto> getAllStudent();
    StudentResDto getStudentById(Long id);
    StudentResDto insertStudent(StudentReqDto studentReqDto);
    StudentResDto updateStudent(Long id, StudentReqDto studentReqDto);
    void deleteStudent(Long id);
}
