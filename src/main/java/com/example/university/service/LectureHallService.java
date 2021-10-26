package com.example.university.service;

import com.example.university.entity.LectureHall;

import java.util.List;

public interface LectureHallService {
    boolean addLectureHall(int lectureHallNumber);
    LectureHall findLectureHallById(int id);
    List<LectureHall> findAllLectureHalls();
    boolean updateLectureHall(int id, int newNumber);
    boolean deleteLectureHall(int id);
}
