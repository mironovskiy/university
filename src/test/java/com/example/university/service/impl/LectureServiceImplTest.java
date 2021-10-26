package com.example.university.service.impl;

import com.example.university.dao.*;
import com.example.university.entity.*;
import com.example.university.service.LectureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LectureServiceImplTest {

    @Mock
    private SubjectRepo subjectRepo;
    @Mock
    private LectureRepo lectureRepo;
    @Mock
    private LectureHallRepo lectureHallRepo;
    @Mock
    private StudentRepo studentRepo;
    @Mock
    private GroupRepo groupRepo;

    private LectureService lectureService;
    private Group testGroup;
    private LectureHall testLectureHall;
    private Subject testSubject;
    private Lecture testLecture;

    @BeforeEach
    void init() {
        lectureService = new LectureServiceImpl(lectureRepo, groupRepo, lectureHallRepo, subjectRepo, studentRepo);
        testGroup = new Group(772301);
        testLectureHall = new LectureHall(101);
        testSubject = new Subject("Математика");
        testLecture = new Lecture(new Date(2021, 10, 30), testGroup, testLectureHall, testSubject);
    }

    @Test
    void testAddLecture() {
        when(groupRepo.findGroupByNumber(any(Integer.class))).thenReturn(testGroup);
        when(lectureHallRepo.findLectureHallByNumber(any(Integer.class))).thenReturn(testLectureHall);
        when(subjectRepo.findSubjectByName(any(String.class))).thenReturn(testSubject);
        assertTrue(lectureService.addLecture(new Date(2021, 10, 30), testGroup.getNumber(), testLectureHall.getNumber(), testSubject.getName()));
    }

    @Test
    void testUpdateLecture() {
        when(lectureRepo.findLectureById(any(Integer.class))).thenReturn(testLecture);
        when(groupRepo.findGroupByNumber(any(Integer.class))).thenReturn(testGroup);
        when(lectureHallRepo.findLectureHallByNumber(any(Integer.class))).thenReturn(testLectureHall);
        when(subjectRepo.findSubjectByName(any(String.class))).thenReturn(testSubject);
        assertTrue(lectureService.updateLecture(1, new Date(2021, 10, 31), 772301, 102, "Математика"));
    }

    @Test
    void testDeleteLecture() {
        when(lectureRepo.findLectureById(any(Integer.class))).thenReturn(testLecture);
        assertTrue(lectureService.deleteLecture(1));
    }

}