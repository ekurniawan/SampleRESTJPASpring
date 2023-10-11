package com.actualtraining.samplerestjpa.repository;
import com.actualtraining.samplerestjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
