package com.example.university.service;

import com.example.university.entity.Lecture;

import java.sql.Date;
import java.util.List;

public interface LectureService {
    boolean addLecture(Date date,int groupNumber, int lectureHallNumber, String subjectName);
    List<Lecture> findLectureForStudent(int studentId, Date date);
    List<Lecture> findAllLectures();
    boolean updateLecture(int id, Date date,int groupNumber, int lectureHallNumber, String subjectName);
    boolean deleteLecture(int id);
}
