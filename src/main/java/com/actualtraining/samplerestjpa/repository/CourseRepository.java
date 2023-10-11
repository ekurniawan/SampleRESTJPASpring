package com.actualtraining.samplerestjpa.repository;

import com.actualtraining.samplerestjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
