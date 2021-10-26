package com.example.university.service.impl;

import com.example.university.dao.LectureHallRepo;
import com.example.university.entity.LectureHall;
import com.example.university.service.LectureHallService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LectureHallServiceImplTest {

    @Mock
    private LectureHallRepo lectureHallRepo;

    private LectureHallService lectureHallService;

    private LectureHall testLectureHall;

    @BeforeEach
    public void init(){
        lectureHallService = new LectureHallServiceImpl(lectureHallRepo);
        testLectureHall = new LectureHall(101);
    }

    @Test
    void testAddLectureHall() {
        Mockito.when(lectureHallRepo.findLectureHallByNumber(Mockito.any(Integer.class))).thenReturn(null);
        assertTrue(lectureHallService.addLectureHall(101));
    }

    @Test
    void testUpdateLectureHall() {
        Mockito.when(lectureHallRepo.findLectureHallByNumber(Mockito.any(Integer.class))).thenReturn(null);
        Mockito.when(lectureHallRepo.findLectureHallById(Mockito.any(Integer.class))).thenReturn(testLectureHall);
        assertTrue(lectureHallService.updateLectureHall(1, 102));
    }

    @Test
    void testDeleteLectureHall() {
        Mockito.when(lectureHallRepo.findLectureHallById(Mockito.any(Integer.class))).thenReturn(testLectureHall);
        assertTrue(lectureHallService.deleteLectureHall(1));
    }
}