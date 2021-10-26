package com.example.university.dao;

import com.example.university.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentById(int id);
    Student findStudentByNameAndLastname(String name, String lastname);
}
