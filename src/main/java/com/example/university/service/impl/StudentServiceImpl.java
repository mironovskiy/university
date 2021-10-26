package com.example.university.service.impl;

import com.example.university.dao.GroupRepo;
import com.example.university.dao.StudentRepo;
import com.example.university.entity.Student;
import com.example.university.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;
    private GroupRepo groupRepo;

    @Override
    public boolean addStudent(String name, String lastname, int groupNumber) {
        if ((studentRepo.findStudentByNameAndLastname(name, lastname) != null) || (groupRepo.findGroupByNumber(groupNumber) == null)) {
            return false;
        }
        studentRepo.save(new Student(name, lastname, groupRepo.findGroupByNumber(groupNumber)));
        return true;
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepo.findStudentById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public boolean updateStudent(int id, String name, String lastname, int groupNumber) {
        Student student = studentRepo.findStudentById(id);
        if ((student == null) || (groupRepo.findGroupByNumber(groupNumber) == null)) {
            return false;
        }
        student.setName(name);
        student.setLastname(lastname);
        student.setGroupsByGroupId(groupRepo.findGroupByNumber(groupNumber));
        studentRepo.save(student);
        return true;
    }

    @Override
    public boolean deleteStudent(int id) {
        if (studentRepo.findStudentById(id) == null){
            return false;
        }
        studentRepo.delete(studentRepo.findStudentById(id));
        return true;
    }
}
