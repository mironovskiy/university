package com.example.university.service;

import com.example.university.entity.Student;

import java.util.List;

public interface StudentService {
    boolean addStudent(String name, String lastname, int groupNumber);
    Student findStudentById(int id);
    List<Student> findAllStudents();
    boolean updateStudent(int id, String name, String lastname, int groupNumber);
    boolean deleteStudent(int id);
}
