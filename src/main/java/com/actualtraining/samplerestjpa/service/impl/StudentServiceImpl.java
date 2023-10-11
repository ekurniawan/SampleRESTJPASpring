package com.actualtraining.samplerestjpa.service.impl;

import com.actualtraining.samplerestjpa.dto.StudentReqDto;
import com.actualtraining.samplerestjpa.dto.StudentResDto;
import com.actualtraining.samplerestjpa.entity.Student;
import com.actualtraining.samplerestjpa.repository.StudentRepository;
import com.actualtraining.samplerestjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentResDto> getAllStudent() {
        List<StudentResDto> studentResDtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();
        for (Student student : studentList) {
            studentResDtoList.add(StudentResDto.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .age(student.getAge())
                    .build());
        }
        return studentResDtoList;
    }

    @Override
    public StudentResDto getStudentById(Long id) {
        return null;
    }

    @Override
    public StudentResDto insertStudent(StudentReqDto studentReqDto) {
        Student student = Student.builder()
                .name(studentReqDto.getName())
                .age(studentReqDto.getAge())
                .build();

        student = studentRepository.save(student);
        StudentResDto studentResDto = StudentResDto.builder()
                .id(student.getId())
                .name(student.getName())
                .age(student.getAge())
                .build();

        return studentResDto;
    }

    @Override
    public StudentResDto updateStudent(Long id, StudentReqDto studentReqDto) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
