package com.example.university.service.impl;

import com.example.university.dao.GroupRepo;
import com.example.university.dao.StudentRepo;
import com.example.university.entity.Group;
import com.example.university.entity.Student;
import com.example.university.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepo studentRepo;

    @Mock
    private GroupRepo groupRepo;

    private StudentService studentService;

    private Student testStudent;

    private Group testGroup;

    @BeforeEach
    public void init(){
        studentService = new StudentServiceImpl(studentRepo, groupRepo);
        testGroup = new Group(772301);
        testStudent = new Student("Илья", "Мироновский", testGroup);
    }

    @Test
    void testAddStudent() {
        Mockito.when(studentRepo.findStudentByNameAndLastname(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(null);
        Mockito.when(groupRepo.findGroupByNumber(Mockito.any(Integer.class))).thenReturn(testGroup);
        assertTrue(studentService.addStudent(testStudent.getName(), testStudent.getLastname(), testStudent.getGroupsByGroupId().getNumber()));
    }

    @Test
    void testUpdateStudent() {
        Mockito.when(studentRepo.findStudentById(Mockito.any(Integer.class))).thenReturn(testStudent);
        Mockito.when(groupRepo.findGroupByNumber(Mockito.any(Integer.class))).thenReturn(testGroup);
        assertTrue(studentService.updateStudent(1, "newName", "newLastname", 772303));
    }

    @Test
    void testDeleteStudent() {
        Mockito.when(studentRepo.findStudentById(Mockito.any(Integer.class))).thenReturn(testStudent);
        assertTrue(studentService.deleteStudent(1));
    }
}