package com.actualtraining.samplerestjpa.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    @JoinTable(name = "students_courses",
            joinColumns = {
                    @JoinColumn(name = "student_id",referencedColumnName = "id",
                            nullable = false,updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id",referencedColumnName = "id",
                            nullable = false,updatable = false)
            })
    public List<Course> courses;
}
